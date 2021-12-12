package miu.edu.controller;

import miu.edu.dto.CourseDto;
import miu.edu.dto.FacultyDto;
import miu.edu.model.Course;
import miu.edu.model.Faculty;
import miu.edu.repository.CourseRepository;
import miu.edu.service.Implementation.CourseServiceImpl;
import miu.edu.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseServiceImpl courseService;



    @GetMapping(value = "/courses")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @GetMapping(value = "/courses", params = "paged=true")
    public ResponseEntity<?> findAll(Pageable pageable) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, courseService.findAll(pageable));
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, courseService.findById(id));
    }

    @PostMapping("/courses")
    public ResponseEntity<?> addCourse(@RequestBody CourseDto courseDto) {
        Course course = courseService.addCourse(courseDto);
        if (course!= null) {
            return ResponseHandler.respond("Successfully added a course !", HttpStatus.OK, course);
        } else {
            return ResponseHandler.respond("Null entities found", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        courseService.removeCourse(id);
        return ResponseHandler.respond("Successfully deleted a course!", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("courses")
    public ResponseEntity<?> deleteCourses() {
        courseService.removeCourses();
        return ResponseHandler.respond("Successfully deleted a course!", HttpStatus.ACCEPTED);
    }

}
