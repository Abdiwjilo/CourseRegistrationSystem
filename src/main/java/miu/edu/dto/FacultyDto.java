package miu.edu.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultyDto {

    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String title;
}
