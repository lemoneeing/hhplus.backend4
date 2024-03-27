package cleanarchitecture.course_not_used;

import cleanarchitecture.business.CourseService_old;
import cleanarchitecture.data.Course;
import cleanarchitecture.data.CourseRepository;
import cleanarchitecture.data.EnrolleeRepository;
import cleanarchitecture.user_not_used.User;
import cleanarchitecture.user_not_used.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class CourseServiceOldTest {
    CourseService_old service;

    CourseRepository cRepo;
    UserRepository uRepo;

    @BeforeEach
    void beforeEach(){

        Course course = new Course();
        course.setCourseId(1L);
        course.setCourseName("test1");
        course.setCapacity(30);
        course.setApplicants(new ArrayList<Long>());
        course.setDate(LocalDateTime.of(2024, 4, 10, 14, 0));

        cRepo = new WorkshopRepository();
        cRepo.save(course);

        User user = new User();
        user.setUserId(1L);
        uRepo = new EnrolleeRepository();
        uRepo.save(user);

//        service = new CourseService(cRepo, uRepo);
        service = new CourseService_old(cRepo);
    }

    @Test
    void 모든_특강_목록을_가져옴(){
        List<Course> courses = service.getCourses();

        // courses는 repository 에 저장된 모든 특강 목록과 일치해야 함.
        Assertions.assertThat(courses).isEqualTo(cRepo.findAll());
    }

    @Test
    void 특강_신청_처리(){
        Long courseId = 1L;
        Integer initApplicantsCnt = service.getApplicants(courseId).size(); // 현재 강의의 수강 신청자 목록

        Long userId = 1L;
//        service.reserveCourse(courseId, userId);
        service.reserveCourse(courseId);

        Assertions.assertThat(service.getCourseById(courseId).countOfApplicants).isEqualTo(initApplicantsCnt + 1);
        Assertions.assertThat(this.uRepo.findByUserId(userId).getReservedCourseId()).isEqualTo(courseId);
    }

    @Test
    void 특강_마감일_때_신청_실패(){
        Long courseId = 1L;
        Course course = service.getCourseById(courseId);

        //특강 마감 상태 만들기
        course.setCountOfApplicants(course.capacity);

        Long userId = 1L;
//        Boolean result = service.reserveCourse(courseId, userId);

        Assertions.assertThat(service.reserveCourse(courseId)).isEqualTo(courseId);
    }
}