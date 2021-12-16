package miu.edu.controller;

import miu.edu.dto.RegistrationEventDto;
import miu.edu.dto.StudentDto;
import miu.edu.model.Student;
import miu.edu.repository.StudentRepository;
import miu.edu.service.Implementation.StudentServiceImpl;
import miu.edu.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentServiceImpl studentService;



    @GetMapping(value = "/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping(value = "/students", params = "paged=true")
    public ResponseEntity<?> findAll(Pageable pageable) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, studentService.findAll(pageable));
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, studentService.findById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<?> addFaculty(@RequestBody StudentDto studentDto) {
        Student student = studentService.addStudent(studentDto);
        if (student!= null) {
            return ResponseHandler.respond("Successfully added a student !", HttpStatus.OK, student);
        } else {
            return ResponseHandler.respond("Null entities found", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "students/{id}", consumes = "application/json")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        Student student = studentService.updateStudent(id, studentDto);
        return ResponseHandler.respond("Successfully updated a student!", HttpStatus.ACCEPTED, student);
    }

    @DeleteMapping("students/{id}")
    public ResponseEntity<?> deleteFaculty(@PathVariable Long id) {
        studentService.removeStudent(id);
        return ResponseHandler.respond("Successfully deleted a student!", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("students")
    public ResponseEntity<?> deleteFaculties() {
        studentService.removeStudents();
        return ResponseHandler.respond("Successfully deleted a student!", HttpStatus.ACCEPTED);
    }



    //Adding registration request
//    @PostMapping("/students/registrationrequest")
//    public ResponseEntity<?> addRegistrationrequest(@RequestBody RegistrationEventDto registrationEventDto) {
//        Student student = studentService.addStudent(studentDto);
//        if (student!= null) {
//            return ResponseHandler.respond("Successfully added a student !", HttpStatus.OK, student);
//        } else {
//            return ResponseHandler.respond("Null entities found", HttpStatus.BAD_REQUEST);
//        }
//    }


}
