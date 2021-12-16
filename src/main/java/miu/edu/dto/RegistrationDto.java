package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.ElementCollection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
    @NonNull
    @ElementCollection
    private List<Long> student;
    @NonNull
    @ElementCollection
    private List<Long> courses;

}
