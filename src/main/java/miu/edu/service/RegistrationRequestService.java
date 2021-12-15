package miu.edu.service;

import miu.edu.dto.RegistrationRequestDto;
import miu.edu.dto.StudentDto;
import miu.edu.model.RegistrationRequest;
import miu.edu.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RegistrationRequestService {
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable);
    Student findById(Long id);
    RegistrationRequest addRegistrationRequest(RegistrationRequestDto registrationRequestDto);
    void removeStudent(Long id);
    void removeStudents();
    Student updateStudent(Long id, StudentDto studentDto);
}
