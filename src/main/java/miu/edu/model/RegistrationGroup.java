package miu.edu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import miu.edu.dto.AcademicBlockDto;
import miu.edu.dto.StudentDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class RegistrationGroup {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AcademicBlock> academicBlocks = new ArrayList<>();



}
