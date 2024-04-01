package cleanarchitecture.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

class CourseServiceTest{

    CourseRepository cRepo;
    @Autowired
    CourseService svc;
    Long firstCourseId;

    @BeforeEach
    void setUp() {
        svc = new CourseService(this.cRepo);
        this.firstCourseId = svc.createCourse("course1", 1, LocalDateTime.of(2024, 4, 30, 12, 0));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void 특강_신청(){
        Integer initCnt = svc.repository.convertCourse(svc.repository.findById(this.firstCourseId)).getCountOfApplicants();

        Assertions.assertThat(svc.addCourseApplicants(this.firstCourseId)).isEqualTo(initCnt+1);

    }
}