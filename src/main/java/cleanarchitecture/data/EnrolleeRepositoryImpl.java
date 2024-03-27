package cleanarchitecture.data;

import cleanarchitecture.business.IEnrolleeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrolleeRepositoryImpl implements IEnrolleeRepository {
    @Autowired
    IEnrolleeJpaRepository jpaRepository;

    @Override
    public Enrollee save(Enrollee enrollee) {
        jpaRepository.save(enrollee);
        return enrollee;
    }

    @Override
    public Enrollee findByEnrolleeId(Long enrolleeId) {
        jpaRepository.findById(enrolleeId);
        return null;
    }

    @Override
    public Long reserveCourse(Enrollee enrollee, Long courseId) {
        enrollee.setReservedCourseId(courseId);
        return courseId;
    }

    @Override
    public Long findReservedCourse(Enrollee enrollee) {
        return enrollee.getReservedCourseId();
    }
}
