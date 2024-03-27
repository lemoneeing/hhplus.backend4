//package cleanarchitecture.business;
//
//import cleanarchitecture.data.Enrollee;
//import org.springframework.stereotype.Repository;
//
////public class EnrolleeRepository implements UserRepository{
////
////    private static Map<Long, User> usrMap = new ConcurrentHashMap<>();
////    private static long sequence = 0L;
////
////    @Override
////    public User save(User usr) {
////        usrMap.put(usr.getUserId(), usr);
////        return usr;
////    }
////
////    @Override
////    public User findByUserId(Long usrId) {
////        User user = usrMap.get(usrId);
////        if (user != null) return user;
////        else return new User();
////    }
////}
//
//@Repository
//public class EnrolleeRepository {
//    Enrollee save(Enrollee enrollee);
//    Enrollee findByUserId(Long usrId);
//}
