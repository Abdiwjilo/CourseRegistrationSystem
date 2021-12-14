package miu.edu.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import miu.edu.dto.CourseDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter@Setter@ToString

@Entity
public class AcademicBlock {
    @Id
    @GeneratedValue
    private long id;
    private String code;
    private String name;
    private String semester;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Course> courses;


    public AcademicBlock() {}

    public AcademicBlock(String code, String name, String semester, LocalDateTime startDate, LocalDateTime endDate) {
        this.code = code;
        this.name = name;
        this.semester = semester;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }
}
