package miu.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import miu.edu.model.Address;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;

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

    @NonNull
    private Address mailingAddress;

    @NonNull
    private Address homeAddress;
}
