package cleanarchitecture.user;

import cleanarchitecture.course.Course;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EnrolleeRepository implements UserRepository{

    private static Map<Long, User> usrMap = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    @Override
    public User save(User usr) {
        usrMap.put(usr.getUserId(), usr);
        return usr;
    }

    @Override
    public User findByUserId(Long usrId) {
        User user = usrMap.get(usrId);
        if (user != null) return user;
        else return new User();
    }
}
