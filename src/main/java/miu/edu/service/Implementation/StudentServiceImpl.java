package miu.edu.service.Implementation;

import miu.edu.dto.RegistrationEventDto;
import miu.edu.dto.StudentDto;
import miu.edu.model.Address;
import miu.edu.model.Course;
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

        Address mailingAddress = new Address();
        mailingAddress.setStreet(studentDto.getMailingAddress().getStreet());
        mailingAddress.setCity(studentDto.getMailingAddress().getCity());
        mailingAddress.setPostalCode(studentDto.getMailingAddress().getPostalCode());
        mailingAddress.setState_province(studentDto.getMailingAddress().getState_province());
        mailingAddress.setCountry_region(studentDto.getMailingAddress().getCountry_region());


        Address homeAddress = new Address();
        homeAddress.setStreet(studentDto.getHomeAddress().getStreet());
        homeAddress.setCity(studentDto.getHomeAddress().getCity());
        homeAddress.setPostalCode(studentDto.getHomeAddress().getPostalCode());
        homeAddress.setState_province(studentDto.getHomeAddress().getState_province());
        homeAddress.setCountry_region(studentDto.getHomeAddress().getCountry_region());

        student.setMailingAddress(mailingAddress);
        student.setHomeAddress(homeAddress);
        return studentRepository.save(student);
    }


    //Adding Registration request
//    public List<Course> addRegistrationrequest(RegistrationEventDto registrationEventDto){
//
//    }



}
