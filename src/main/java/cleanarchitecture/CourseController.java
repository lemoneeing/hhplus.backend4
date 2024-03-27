package cleanarchitecture;

import cleanarchitecture.business.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {
    @Autowired
    final CourseService courseSvc;

    public CourseController(CourseService courseSvc) {
        this.courseSvc = courseSvc;
    }

    @GetMapping("/")
    public String root(){
        return "redirect:/course/list";
    }

    @PostMapping("reserve/{courseId}")
    @ResponseBody
    public void reserveCourse(@PathVariable("courseId") Long cId){
        Long courseId = courseSvc.isCourseReservable(cId);
        System.out.println(courseSvc.addCourseCountOfApplicants(courseId));
    }
}
