package cleanarchitecture.course;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class WorkshopRepository implements CourseRepository{
    private static Map<Long, Course> courseMap = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    @Override
    public Course save(Course course) {
        courseMap.put(course.getCourseId(), course);
        return course;
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courseMap.values());
    }

    @Override
    public Optional<Course> findByCourseId(Long courseId) {
        return null;
    }

    @Override
    public List<Long> findApplicantsByCourseId(Long courseId) {
        return courseMap.get(courseId).getApplicants();
    }

    @Override
    public Boolean updateApplicants(Long courseId, Long userId) {
        List<Long> applicants = courseMap.get(courseId).getApplicants();
        applicants.add(userId);

        courseMap.get(courseId).setApplicants(applicants);
        return true;
    }


}
