package miu.edu.service;

import miu.edu.dto.StudentDto;
import miu.edu.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable);
    Student findById(Long id);
    Student addStudent(StudentDto studentDto);
    void removeStudent(Long id);
    void removeStudents();
    Student updateStudent(Long id, StudentDto studentDto);
}
