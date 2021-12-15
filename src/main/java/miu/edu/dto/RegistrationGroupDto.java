package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationGroupDto {

    @NonNull
    private List<StudentDto> students;
    @NonNull
    private List<AcademicBlockDto> academicBlocks;

}
