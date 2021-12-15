package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import miu.edu.model.Course;
import miu.edu.model.Student;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseOfferingDto {
    @NonNull
    private Long id;
    @NonNull
    private String code;
    @NonNull
    private long capacity;

    @NonNull
    private List<CourseDto> courses;

    @NonNull
    private List<StudentDto> students;

    @NonNull
    private List<AcademicBlockDto> academicBlocks;

}
