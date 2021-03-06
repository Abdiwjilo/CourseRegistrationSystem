package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcademicBlockDto {

    @NonNull
    private long id;
    @NonNull
    private String code;
    @NonNull
    private String name;
    @NonNull
    private String semester;
    @NonNull
    private LocalDateTime startDate;
    @NonNull
    private LocalDateTime endDate;
    @NonNull
    private List<CourseDto> courses;
}
