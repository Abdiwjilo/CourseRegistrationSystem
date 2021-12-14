package miu.edu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter@Setter@ToString

@Entity
public class Student {

    @Id
    @GeneratedValue
    private long id;

    private String studentId;
    private String name;
    private String email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street" , column = @Column(name = "mailingStreet")),
            @AttributeOverride(name = "city" , column = @Column(name = "mailingCity")),
            @AttributeOverride(name = "postalCode" , column = @Column(name = "mailingPostalCode")),
            @AttributeOverride(name = "state_province" , column = @Column(name = "mailingStateProvince")),
            @AttributeOverride(name = "country_region" , column = @Column(name = "mailingCountry"))

    })
    private Address mailingAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street" , column = @Column(name = "homeStreet")),
            @AttributeOverride(name = "city" , column = @Column(name = "homeCity")),
            @AttributeOverride(name = "postalCode" , column = @Column(name = "homePostalCode")),
            @AttributeOverride(name = "state_province" , column = @Column(name = "homeStateProvince")),
            @AttributeOverride(name = "country_region" , column = @Column(name = "homeCountry"))

    })
    private Address homeAddress;

//    @OneToMany
//    private List<Registration> registrations = new ArrayList<>();


    public Student() {}

    public Student(String studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }
}
