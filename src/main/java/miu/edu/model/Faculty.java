package miu.edu.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter@Setter@ToString

@Entity
public class Faculty {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    private String title;


    public Faculty() {}

    public Faculty(String name, String email, String title) {
        this.title = title;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }


}
