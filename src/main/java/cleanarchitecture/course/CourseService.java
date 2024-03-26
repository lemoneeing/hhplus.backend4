package cleanarchitecture.course;

import cleanarchitecture.user.User;
import cleanarchitecture.user.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@RequiredArgsConstructor
@Service
@NoArgsConstructor
public class CourseService {
    private CourseRepository courseRepo;
    private UserRepository userRepo;

    public CourseService(CourseRepository courseRepo, UserRepository userRepo){
        this.courseRepo = courseRepo;
        this.userRepo = userRepo;
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
    
    public Boolean reserveCourse(Long courseId, Long userId){
        // 신청 성공이면 True, 실패면 False 를 반환
        Course course = courseRepo.findByCourseId(courseId);
        User user = userRepo.findByUserId(userId);

        // 현재 신청자 수가 정원 보다 작을 때에만 신청 성공
        if (course.getCountOfApplicants() < course.getCapacity()){
            courseRepo.updateApplicants(courseId, userId);
            user.setReservedCourseId(courseId);
            return true;
        }
        return false;
    }

}
