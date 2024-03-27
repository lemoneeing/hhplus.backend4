package cleanarchitecture.business;

import org.springframework.stereotype.Service;

@Service
public class CourseService {
    public final ICourseRepository repository;

    public CourseService(ICourseRepository repository) {
        this.repository = repository;
    }

    // 신청하려는 특강이 신청 가능한 상태인지 확인
    public Long isCourseReservable(Long courseId) {
        if(repository.findCountOfApplicantsByCourseId(courseId) < repository.findByCourseId(courseId).getCapacity()) return courseId;
        else return -1L; // courseID 는 무조건 양수여야 한다는 규칙 필요
    }

    // 특강 신청자 수 증가
    public Integer addCourseCountOfApplicants(Long courseId){
        repository.addCountOfApplicants(repository.findByCourseId(courseId));
        return repository.findCountOfApplicantsByCourseId(courseId);
    }
}
