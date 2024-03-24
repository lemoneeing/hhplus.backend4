package cleanarchitecture.user;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Enrollee implements User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    public Long reservedCourseId;

}
