package cleanarchitecture.data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CourseRepositoryImplTest {
    @Autowired
    ICourseJpaRepository repo;

    @Test
    void 엔티티_저장(){
        Course c = new Course();
        c.setCourseId(1L);
        c.setCourseName("course1");
        c.setCapacity(30);
        c.setCountOfApplicants(10);

        repo.save(c);

//        Assertions.assertThat(repo.findById(1L)).isEqualTo(c);
    }
}