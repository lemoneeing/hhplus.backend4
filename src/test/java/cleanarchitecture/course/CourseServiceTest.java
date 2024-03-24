package cleanarchitecture.course;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {
    CourseService service;

    @Autowired
    CourseRepository repository;

    @BeforeEach
    void beforeEach(){
        service = new CourseService(repository);
    }

    @Test
    void 모든_특강_목록을_가져옴(){
        List<Course> courses = service.getCourses();

        // repository 의 기능은 service 시험에선 알빠노... but 시험할 때 repository 의 멤버가 필요하면 어떻게 접근하지?
        // courses는 repository 에 저장된 모든 특강 목록과 일치해야 함.
        Assertions.assertThat(courses).isEqualTo(repository.findAll());
    }

    @Test
    void 특강_신청_처리(){
        Long userId = 1L;
        Long courseId = 1L;

        repository.applicants.clear();
        Integer initApplicantCnt = repository.applicants.size();

        Boolean result = service.reserve(userId, courseId);

        // 특강의 applicantCount 값이 1 증가해야 함.
        Assertions.assertThat(result).isEqualTo(True);
        Assertions.assertThat(repository.applicants.size()).isEqualTo(initApplicantCnt+1); // Repository Test 로 가는 게 더 적절한건가?
    }

    @Test
    void 특강_마감일_때_신청_실패_처리(){
        Long userId = 1L;
        Long courseId = 1L;
        
        // 특강 마감 상태 만들기
        for (int i=0; i < repository.capacity; i++){
            repository.applicants.add(0L);
        }
        Boolean result = service.reserve(userId, courseId);

        // 실패해야 함.
//        assertThrows();
    }

    @Test
    void 동일_사용자가_2개_특강을_신청(){
        Long userId = 1L;
        Long courseId1 = 1L;
        Long courseId2 = 1L;

        Boolean result = service.reserve(userId, courseId1); // 성공해야 함.
        Boolean result = service.reserve(userId, courseId2); // 실패해야 함.

        // 실패해야 함.
//        assertThrows();
    }


}