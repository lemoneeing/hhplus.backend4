package cleanarchitecture.data;

import cleanarchitecture.data.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

//public interface CourseRepository extends JpaRepository<Course, Integer> {
//}

@Repository
public interface CourseRepository {
    Course save(Course course);
    List<Course> findAll();
    Course findByCourseId(Long courseId);
    List<Long> findApplicantsByCourseId(Long courseId);
    Boolean updateApplicants(Long courseId);
}