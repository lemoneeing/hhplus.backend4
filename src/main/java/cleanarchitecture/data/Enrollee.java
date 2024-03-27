package cleanarchitecture.data;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Enrollee{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    public Long reservedCourseId;

}
