package miu.edu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

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
