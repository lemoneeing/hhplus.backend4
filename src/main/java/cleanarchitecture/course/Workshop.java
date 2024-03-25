package cleanarchitecture.course;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

//@Entity
//@Getter
//public class Workshop implements Course{
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private Long courseId;
//
//    @Column(length=50)
//    public String courseName;
//
//    @Column
//    public Integer capacity;
//
//    @Column
//    public List<Long> applicants; // DB Column 에 List type 을 사용해도 되는지...?
//
//    @Column
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    public LocalDateTime date;
//}
