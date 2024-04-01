package cleanarchitecture.controller;

import cleanarchitecture.application.CourseService;
import cleanarchitecture.application.EnrollmentService;
import cleanarchitecture.controller.request.EnrollRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enrollment")
public class EnrollmentController {

    private final CourseService courseSvc;
    private final EnrollmentService enrollmentSvc;

    // 특강 신청
    @PostMapping("{courseId}")
    @ResponseBody
    public String enrollCourse(@PathVariable Long courseId, @RequestBody EnrollRequest enrollRequest){
        Long userId = enrollRequest.getUserId();

        // 특강을 더 이상 신청할 수 없는 사용자일 경우
        if (!enrollmentSvc.isUserFree(userId)){
            return "실패! 더 이상 신청할 수 없습니다.";
        }

        // 특강이 마감되었을 경우
        if (!courseSvc.CourseHasSpace(courseId)){
            return "실패! 특강이 마감되었습니다.";
        }
        enrollmentSvc.createEnrollment(courseId, userId);
        courseSvc.addCourseApplicants(courseId);

        String courseName = courseSvc.findCourseNameByCourseID(courseId);
        return "성공! '"+ courseName + "' 를 수강 신청하였습니다. ";
    }
    
    // 신청한 강의 조회
    @GetMapping("{userID}")
    @ResponseBody
    public String checkCourseEnrolled(@PathVariable Long userId){
        Long courseId = enrollmentSvc.showCourseIdByUserId(userId);
        if (courseSvc.doesCourseExist(courseId)) {
            return "당신은 '" + courseSvc.findCourseNameByCourseID(courseId) + "' 수강 신청을 완료하였습니다.";
        }
        else
            return "당신은 수강 신청한 강의가 없습니다.";
    }
}
