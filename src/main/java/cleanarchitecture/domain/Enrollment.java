package cleanarchitecture.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    public Long courseId;

    @Column
    public Long userId;

    Enrollment(Long courseId, Long userId){
        this.courseId = courseId;
        this.userId = userId;
    }
}
