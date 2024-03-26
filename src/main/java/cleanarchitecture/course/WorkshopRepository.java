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
    public Course findByCourseId(Long courseId) {
        Course course = courseMap.get(courseId);
        if (course != null) return course;
        else return new Course();
    }

    @Override
    public List<Long> findApplicantsByCourseId(Long courseId) {
        return courseMap.get(courseId).getApplicants();
    }

    @Override
    public Boolean updateApplicants(Long courseId, Long userId) {
        List<Long> applicants = courseMap.get(courseId).getApplicants();
        applicants.add(userId);

        Course course = courseMap.get(courseId);
        course.setApplicants(applicants);
        course.setCountOfApplicants(applicants.size());
        return true;
    }

    public Integer getApplicantsCount(Long courseId){
        return courseMap.get(courseId).countOfApplicants;
    }
}
