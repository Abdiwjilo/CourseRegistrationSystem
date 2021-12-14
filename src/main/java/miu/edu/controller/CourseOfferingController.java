package miu.edu.controller;

import miu.edu.dto.CourseOfferingDto;
import miu.edu.model.CourseOffering;
import miu.edu.repository.CourseOfferingRepository;
import miu.edu.service.Implementation.CourseOfferingServiceImpl;
import miu.edu.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseOfferingController {
    @Autowired
    CourseOfferingRepository courseOfferingRepository;
    @Autowired
    CourseOfferingServiceImpl courseOfferingService;



    @GetMapping(value = "/courseofferings")
    public List<CourseOffering> findAll() {
        return courseOfferingService.findAll();
    }

    @GetMapping(value = "/courseofferings", params = "paged=true")
    public ResponseEntity<?> findAll(Pageable pageable) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, courseOfferingService.findAll(pageable));
    }

    @GetMapping("/courseofferings/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, courseOfferingService.findById(id));
    }

    @PostMapping("/courseofferings")
    public ResponseEntity<?> addCourseOffering(@RequestBody CourseOfferingDto courseOfferingDto) {
        CourseOffering courseOffering = courseOfferingService.addCourseOffering(courseOfferingDto);
        if (courseOffering!= null) {
            return ResponseHandler.respond("Successfully added a course offerings !", HttpStatus.OK, courseOffering);
        } else {
            return ResponseHandler.respond("Null entities found", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "courseofferings/{id}", consumes = "application/json")
    public ResponseEntity<?> updateCourseOffering(@PathVariable Long id, @RequestBody CourseOfferingDto courseOfferingDto) {
        CourseOffering courseOffering = courseOfferingService.updateCourseOffering(id, courseOfferingDto);
        return ResponseHandler.respond("Successfully updated a course offering!", HttpStatus.ACCEPTED, courseOffering);
    }

    @DeleteMapping("courseofferings/{id}")
    public ResponseEntity<?> deleteCourseOffering(@PathVariable Long id) {
        courseOfferingService.removeCourseOffering(id);
        return ResponseHandler.respond("Successfully deleted a course!", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("courseofferings")
    public ResponseEntity<?> deleteCourseOfferings() {
        courseOfferingService.removeCourseOfferings();
        return ResponseHandler.respond("Successfully deleted a course offering!", HttpStatus.ACCEPTED);
    }
}
