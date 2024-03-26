package cleanarchitecture.user;

import cleanarchitecture.course.Course;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface UserRepository {
    User save(User usr);
    User findByUserId(Long usrId);
}
