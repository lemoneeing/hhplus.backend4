package cleanarchitecture.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnrollmentJpaRepository extends JpaRepository<Enrollment, Long> {
}
