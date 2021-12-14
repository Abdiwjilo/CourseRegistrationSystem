package miu.edu.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRole {
    public enum Role {
        ADMIN, STUDENT
    }

    @Enumerated(EnumType.STRING)
    private Role role;
}
