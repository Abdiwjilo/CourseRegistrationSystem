package miu.edu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Getter@Setter@ToString

@Entity

public class Course {

    @Id
    @GeneratedValue
    private long id;

    private String code;
    private String name;
    private String description;


    public Course() {}

    public Course(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }
}
