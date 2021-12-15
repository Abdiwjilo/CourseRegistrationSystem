package miu.edu.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class CourseOffering {

    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private long capacity;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Course> courses;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AcademicBlock> academicBlocks;

}
