package cleanarchitecture.data;

import cleanarchitecture.business.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CourseRepositoryImpl implements ICourseRepository {
    @Autowired
    ICourseJpaRepository jpaRepository;

    @Override
    public Course save(Course course) {
        jpaRepository.save(course);
        return course;
    }

    @Override
    public Course findByCourseId(Long courseId) {
        Optional<Course> opt = jpaRepository.findById(courseId);
        if (opt.isPresent()) return opt.get();
        else return null;
    }

    @Override
    public Integer findCountOfApplicantsByCourseId(Long courseId) {
        Optional<Course> opt = jpaRepository.findById(courseId);
        if (opt.isPresent()) {
            Course course = opt.get();
            return course.getCountOfApplicants();
        }

        return -1; // 이왕이면 error 를 발생하도록 하면 좋을 것 같다.
    }

    @Override
    public Integer addCountOfApplicants(Course course) {
        course.setCountOfApplicants(course.getCountOfApplicants() + 1);
        return course.getCountOfApplicants(); // 여기서는 +1 된 값이 반환되지만 CourseService 의 add~ 에서는 다시 원래 값으로 반환됨...ㅠ
    }
}
