package cleanarchitecture.course;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {
    CourseService service;

    CourseRepository repository;

    @BeforeEach
    void beforeEach(){

        Course course = new Course();
        course.setCourseId(1L);
        course.setCourseName("test1");
        course.setCapacity(30);
        course.setApplicants(new ArrayList<Long>());
        course.setDate(LocalDateTime.of(2024, 4, 10, 14, 0));

        repository = new WorkshopRepository();
        repository.save(course);

        service = new CourseService(repository);
    }

    @Test
    void 모든_특강_목록을_가져옴(){
        List<Course> courses = service.getCourses();

        // courses는 repository 에 저장된 모든 특강 목록과 일치해야 함.
        Assertions.assertThat(courses).isEqualTo(repository.findAll());
    }

    @Test
    void 특강_신청_처리(){
        Long courseId = 1L;
        Integer initApplicantsCnt = service.getApplicants(courseId).size(); // 현재 강의의 수강 신청자 목록

        Long userId = 1L;
        service.reserveCourse(courseId, userId);

        Assertions.assertThat(service.getCourseById(courseId).countOfApplicants).isEqualTo(initApplicantsCnt + 1);
    }

    @Test
    void 특강_마감일_때_신청_실패(){
        Long courseId = 1L;
        Course course = service.getCourseById(courseId);

        //특강 마감 상태 만들기
        course.setCountOfApplicants(course.capacity);

        Long userId = 1L;
        Boolean result = service.reserveCourse(courseId, userId);

        Assertions.assertThat(result).isEqualTo(false);
    }
}