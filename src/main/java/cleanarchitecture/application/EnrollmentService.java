package cleanarchitecture.application;

import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
    final IEnrollmentRepository repository;
    public EnrollmentService(IEnrollmentRepository repo) {
        this.repository = repo;
    }

    public void createEnrollment(Long courseId, Long userId){
        repository.save(courseId, userId);
    }

    public Long showCourseIdByUserId(Long userId){
        return repository.findCourseIdByUserId(userId);
    }

    public Boolean isUserFree(Long userId){
        if (repository.findCourseIdByUserId(userId) == -1) return true;
        else return false;
    }
}
