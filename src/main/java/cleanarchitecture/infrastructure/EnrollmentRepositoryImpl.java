package cleanarchitecture.infrastructure;

import cleanarchitecture.application.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EnrollmentRepositoryImpl implements EnrollmentRepository {
    @Autowired
    JpaEnrollmentRepository jpaRepository;  // Jpa 사용에 익숙하지 않아서 Member 로 주입

    @Override
    public Enrollment save(Long courseId, Long userId) {
        Enrollment enrollment = new Enrollment(courseId, userId);
        jpaRepository.save(enrollment);
        return enrollment;
    }

    @Override
    public Long findCourseIdByUserId(Long userId) {
        Optional<Enrollment> opt = jpaRepository.findById(userId);
        if (opt.isPresent()) return opt.get().courseId;
        else return -1L;
    }


}
