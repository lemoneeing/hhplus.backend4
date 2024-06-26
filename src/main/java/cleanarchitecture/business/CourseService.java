package cleanarchitecture.business;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

// Course 를 모르게 하고 싶음.
@Service
public class CourseService {
    public final ICourseRepository repository;

    public CourseService(ICourseRepository repository) {
        this.repository = repository;
    }

    // 특강 추가 후 특강 Id 반환
    public Long createCourse(String courseName, Integer courseCapacity, LocalDateTime courseDate){
        return repository.create(courseName, courseCapacity, courseDate).getCourseId();
    }

    // 해당 ID 를 갖는 특강의 존재 여부 반환
    public Boolean doesCourseExist(Long courseId){
        if (repository.findByCourseId(courseId).isPresent()) return true;
        else return false;
    }
    
    // 특강명 반환. 조회 관련 로직
    public String findCourseNameByCourseID(Long courseId){
        return repository.convertCourse(repository.findByCourseId(courseId)).getCourseName();
    }
    
    
    // 신청 관련 로직
    // 신청하려는 특강에 여석이 남아 있는 상태인지 확인
    public Boolean CourseHasSpace(Long courseId) {
        // 현재까지의 특강 신청자 수 +1 < 특강 정원
        if (repository.findCountOfApplicants(courseId) + 1
                < repository.convertCourse(repository.findByCourseId(courseId)).getCapacity())
            return true;
        else
            return false;
    }

    // 특강 신청자 수 증가
    public Integer addCourseApplicants(Long courseId){
        return repository.addCountOfApplicants(courseId);
    }
}

//class CourseManager {
//
//}
