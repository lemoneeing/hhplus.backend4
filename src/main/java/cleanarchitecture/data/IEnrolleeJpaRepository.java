package cleanarchitecture.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnrolleeJpaRepository extends JpaRepository<Enrollee, Long> {
}
