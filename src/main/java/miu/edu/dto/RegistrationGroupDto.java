package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import miu.edu.model.Student;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationGroupDto {

    @NonNull
    private List<CourseDto> courses;

    private List<Student> students;
}
