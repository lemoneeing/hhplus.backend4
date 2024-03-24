package cleanarchitecture.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//@RequiredArgsConstructor
@Service
public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepo){
        this.courseRepository = courseRepo;
    }

    public List<Course> getCourses() {
        // 수강 신청 전에 특강 목록을 보여줌.
        return this.courseRepository.findAll();
    }
    
    public Boolean reserve(){
        // 신청 성공이면 True, 실패면 False 를 반환
        return true;
    }
}
