package cleanarchitecture.infrastructure;

import cleanarchitecture.application.ICourseRepository;
import cleanarchitecture.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class CourseRepositoryImpl implements ICourseRepository {
    @Autowired
    final ICourseJpaRepository jpaRepository; // Jpa 사용에 익숙하지 않아서 Member 로 주입

    public CourseRepositoryImpl(ICourseJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Course create(String courseName, Integer capacity, LocalDateTime courseDate) {
        Course c = new Course(courseName, capacity, courseDate);
        jpaRepository.save(c);
        return c;
    }

    @Override
    public Optional<Course> findByCourseId(Long courseId) {
        return jpaRepository.findById(courseId);
    }

    public Course convertCourse(Optional<Course> opt){
        if (opt.isPresent()) return opt.get();
        else throw new RuntimeException("그런 강의 없음.");
    }

    @Override
    public Integer findCountOfApplicants(Long courseId) {
        Course course = convertCourse(findByCourseId(courseId));
        return course.getCountOfApplicants();
    }

    @Override
    public Integer addCountOfApplicants(Long courseId) {
        Course course = convertCourse(findByCourseId(courseId));
        course.setCountOfApplicants(course.getCountOfApplicants() + 1);
        return course.getCountOfApplicants(); // 여기서는 +1 된 값이 반환되지만 CourseService 의 add~ 에서는 다시 원래 값으로 반환됨...ㅠ
    }
}
