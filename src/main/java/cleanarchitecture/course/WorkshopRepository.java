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
}
