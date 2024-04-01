package cleanarchitecture;

import cleanarchitecture.application.CourseService;
import cleanarchitecture.domain.Course;
import cleanarchitecture.controller.EnrollmentController;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class EnrollmentControllerTest {

    @Autowired
    EnrollmentController controller;
    @Autowired
    CourseService cSvc;

    @BeforeEach
    void beforeEach(){
        Course c = this.cSvc.repository.create("course1", 30, LocalDateTime.of(2024, 4, 30, 12, 0));
        c.setCountOfApplicants(10);
    }


}