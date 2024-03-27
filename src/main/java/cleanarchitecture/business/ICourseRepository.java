package cleanarchitecture.business;

import cleanarchitecture.data.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository {
    Course save(Course course);
    Course findByCourseId(Long courseId);
    Integer findCountOfApplicantsByCourseId(Long courseId);
    Integer addCountOfApplicants(Course course);
}