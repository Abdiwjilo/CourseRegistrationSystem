package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import miu.edu.model.Course;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequestDto {


    @NonNull
    private long studentId;
    @NonNull
    private long academicBlockId;
    @NonNull
    private List<Long> coursesId;
}
