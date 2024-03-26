package cleanarchitecture.course;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//@RequiredArgsConstructor
@Service
@NoArgsConstructor
public class CourseService {
    private CourseRepository courseRepo;

    public CourseService(CourseRepository courseRepo){
        this.courseRepo = courseRepo;
    }

    public List<Course> getCourses() {
        // 수강 신청 전에 특강 목록을 보여줌.
        return courseRepo.findAll();
    }

    public Course getCourseById(Long courseId){
        return courseRepo.findByCourseId(courseId);
    }

    public List<Long> getApplicants(Long courseId){
        return courseRepo.findApplicantsByCourseId(courseId);
    }
    
    public Boolean reserveCourse(Long courseId){
        // 신청 성공이면 True, 실패면 False 를 반환
        Course course = courseRepo.findByCourseId(courseId);
        
        // 이미 특강 신청을 완료한 사용자이면 신청 실패 -> User 를 참조하지 않고 해결할 수 있는 방법은?
//        if (user.getReservedCourseId() != null) return false;

        // 현재 신청자 수가 정원 보다 크거나 같으면 신청 실패
        if (course.getCountOfApplicants() >= course.getCapacity()) return false;
        
        // 그외 경우는 신청 성공
        courseRepo.updateApplicants(courseId);
        return true;
    }

}
