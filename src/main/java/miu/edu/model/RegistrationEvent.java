package miu.edu.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter@Setter@ToString
@Entity
public class RegistrationEvent {

    @Id
    @GeneratedValue
    public Long id;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RegistrationGroup> registrationGroups;

    public RegistrationEvent() {}

//    public RegistrationEvent(LocalDateTime startDate, LocalDateTime endDate) {
//        this.startDate = startDate;
//        this.endDate = endDate;
//    }

//    public long getId() {
//        return id;
//    }

}
