package cleanarchitecture.infrastructure;

import cleanarchitecture.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
