package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    @NonNull
    private String studentId;
    @NonNull
    private String name;
    @NonNull
    private String email;
}
