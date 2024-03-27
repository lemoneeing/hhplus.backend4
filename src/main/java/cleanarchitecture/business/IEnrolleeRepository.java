package cleanarchitecture.business;

import cleanarchitecture.data.Enrollee;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnrolleeRepository {
    Enrollee save(Enrollee enrollee);
    Enrollee findByEnrolleeId(Long enrolleeId);
    Long reserveCourse(Enrollee enrollee, Long courseId);
    Long findReservedCourse(Enrollee enrollee);
}