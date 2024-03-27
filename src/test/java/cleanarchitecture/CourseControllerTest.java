package cleanarchitecture;

import cleanarchitecture.business.CourseService;
import cleanarchitecture.data.Course;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseControllerTest {

    @Autowired
    CourseController controller;
    @Autowired
    CourseService cSvc;

    @BeforeEach
    void beforeEach(){

        Course c = new Course();
        c.setCourseId(1L);
        c.setCourseName("course1");
        c.setCapacity(30);
        c.setCountOfApplicants(10);

        this.cSvc.repository.save(c);
    }

    @Test
    void 특강_신청(){
        Long cId = 1L;
        Integer initCnt = cSvc.repository.findCountOfApplicantsByCourseId(cId);
        controller.reserveCourse(cId);

        Assertions.assertThat(cSvc.repository.findCountOfApplicantsByCourseId(cId)).isEqualTo(initCnt+1);
    }
}