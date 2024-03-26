package cleanarchitecture.course;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long courseId;

    @Column(length=50)
    public String courseName;

    @Column
    public Integer capacity;

    @Column
    public List<Long> applicants; // DB Column 에 List type 을 사용해도 되는지...?

    @Column
    public Integer countOfApplicants = 0;

    @Column
    @DateTimeFormat(pattern="yy-MM-dd HH:mm")
//    @JsonFormat(pattern="yy-MM-dd HH:mm")
    public LocalDateTime date;

}
