package cleanarchitecture;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Getter
public class ImplementedCourse implements Course{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer courseId;

    @Column(length=50)
    public String courseName;

    @Column
    public Integer capacity;

    @Column
    public Integer reserved;

    @Column
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public LocalDateTime date;
}
