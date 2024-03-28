package cleanarchitecture.business;

import cleanarchitecture.persistence.Enrollment;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnrollmentRepository {
    // 수강 신청 내역 생성
    Enrollment save(Long courseId, Long userId);
    
    // 사용자 ID 로 신청한 특강 ID 를 반환
    Long findCourseIdByUserId(Long userId);


}