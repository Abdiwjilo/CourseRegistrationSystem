package miu.edu.service.Implementation;

import miu.edu.dto.StudentDto;
import miu.edu.model.Student;
import miu.edu.repository.StudentRepository;
import miu.edu.service.StudentService;
import miu.edu.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found"));
    }


    @Override
    public void removeStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " not found for deletion"));

        studentRepository.delete(student);
    }

    @Override
    public void removeStudents() {
        studentRepository.deleteAll();
    }

    @Override
    public  Student updateStudent(Long id, StudentDto studentDto){
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student with id" + id + " not found for update"));

        student.setStudentId(studentDto.getStudentId());
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        studentRepository.flush();
        return student;
    }


    @Override
    public Student addStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setStudentId(studentDto.getStudentId());
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        return studentRepository.save(student);
    }

}
