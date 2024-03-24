package cleanarchitecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CourseController {
    @GetMapping("/")
    public String root(){
        return "redirect:/course/list";
    }

    @GetMapping("course/list")
    @ResponseBody
    public String course_list(){
        return "HH Plus Workshops";
    }

}
