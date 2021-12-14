package miu.edu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Student student;

    @OneToMany
    private List<CourseOffering> courseOfferings = new ArrayList<>();
}
