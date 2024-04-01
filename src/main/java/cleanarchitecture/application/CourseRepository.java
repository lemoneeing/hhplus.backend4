package cleanarchitecture.application;

import cleanarchitecture.domain.Course;

import java.time.LocalDateTime;
import java.util.Optional;

public interface CourseRepository {
    // 강의 추가
    Course create(String courseName, Integer capacity, LocalDateTime courseDate);

    // 강의 ID 로 Course 객체 탐색 - jpaRepository 의 findById 사용
    Optional<Course> findById(Long courseId);

    // jpaRepo 의 findById 반환 Type 인 Optional 을 온갖군데에서 처리해줘야 하는 귀찮음 해결용
    Course convertCourse(Optional<Course> opt);

    // 현재까지의 신청자 수 반환
    Integer findCountOfApplicantsById(Long courseId);

    // 신청자 수 1 증가
    Integer addCountOfApplicants(Long courseId);
}