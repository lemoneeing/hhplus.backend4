package cleanarchitecture.infrastructure;

import cleanarchitecture.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCourseRepository extends JpaRepository<Course, Long> {
}
