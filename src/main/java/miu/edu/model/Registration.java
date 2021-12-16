package miu.edu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString

@Entity
public class Registration {

        @Id
        @GeneratedValue
        private long id;

        @OneToOne
        private Student students;

        @ManyToMany
        private List<Course> courses;

}
