package miu.edu.controller;

import miu.edu.dto.FacultyDto;
import miu.edu.model.Faculty;
import miu.edu.repository.FacultyRepository;
import miu.edu.service.Implementation.FacultyServiceImpl;
import miu.edu.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class FacultyController {

    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    FacultyServiceImpl facultyService;



    @GetMapping(value = "/faculties")
    public List<Faculty> findAll() {
        return facultyService.findAll();
    }

    @GetMapping(value = "/faculties", params = "paged=true")
    public ResponseEntity<?> findAll(Pageable pageable) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, facultyService.findAll(pageable));
    }

    @GetMapping("/faculties/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, facultyService.findById(id));
    }

    @PostMapping("/faculties")
    public ResponseEntity<?> addFaculty(@RequestBody FacultyDto flightDto) {
        Faculty faculty = facultyService.addFaculty(flightDto);
        if (faculty!= null) {
            return ResponseHandler.respond("Successfully added a faculty !", HttpStatus.OK, faculty);
        } else {
            return ResponseHandler.respond("Null entities found", HttpStatus.BAD_REQUEST);
        }
    }

        @DeleteMapping("faculties/{id}")
        public ResponseEntity<?> deleteFaculty(@PathVariable Long id) {
            facultyService.removeFaculty(id);
            return ResponseHandler.respond("Successfully deleted a faculty!", HttpStatus.ACCEPTED);
        }
    @DeleteMapping("faculties")
    public ResponseEntity<?> deleteFaculties() {
        facultyService.removeFaculties();
        return ResponseHandler.respond("Successfully deleted a faculty!", HttpStatus.ACCEPTED);
    }
}
