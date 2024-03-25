package cleanarchitecture.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//public interface CourseRepository extends JpaRepository<Course, Integer> {
//}

public interface CourseRepository {
    Course save(Course course);
    List<Course> findAll();
    Optional<Course> findByCourseId(Long courseId);
    List<Long> findApplicantsByCourseId(Long courseId);
    Boolean updateApplicants(Long courseId, Long userId);
}