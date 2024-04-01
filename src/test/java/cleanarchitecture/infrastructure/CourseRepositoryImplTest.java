package cleanarchitecture.infrastructure;

import cleanarchitecture.domain.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
class CourseRepositoryImplTest {
    @Autowired
    ICourseJpaRepository repo;

    @Test
    void 엔티티_저장(){
        Course c = new Course("course1", 1, LocalDateTime.of(2024, 12, 31, 12, 0));

        repo.save(c);


//        Assertions.assertThat(repo.findById(1L)).isEqualTo(c);
    }
}