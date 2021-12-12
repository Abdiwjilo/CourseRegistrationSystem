package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    @NonNull
    private String code;
    @NonNull
    private String name;
    @NonNull
    private String description;
}
