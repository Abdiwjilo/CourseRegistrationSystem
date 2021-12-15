package miu.edu.controller;

import miu.edu.dto.RegistrationGroupDto;
import miu.edu.dto.StudentDto;
import miu.edu.model.RegistrationGroup;
import miu.edu.model.Student;
import miu.edu.repository.RegistrationGroupRepository;
import miu.edu.repository.StudentRepository;
import miu.edu.service.Implementation.RegistrationGroupServiceImpl;
import miu.edu.service.Implementation.StudentServiceImpl;
import miu.edu.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationGroupController {
    @Autowired
    RegistrationGroupRepository registrationGroupRepository;
    @Autowired
    RegistrationGroupServiceImpl registrationGroupService;



    @GetMapping(value = "/registrationgroups")
    public List<RegistrationGroup> findAll() {
        return registrationGroupService.findAll();
    }

    @GetMapping(value = "/registrationgroups", params = "paged=true")
    public ResponseEntity<?> findAll(Pageable pageable) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, registrationGroupService.findAll(pageable));
    }

    @GetMapping("/registrationgroups/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, registrationGroupService.findById(id));
    }

    @PostMapping("/registrationgroups")
    public ResponseEntity<?> addRegistrationGroup(@RequestBody RegistrationGroupDto registrationGroupDto) {
        RegistrationGroup registrationGroup = registrationGroupService.addRegistrationGroup(registrationGroupDto);
        if (registrationGroup!= null) {
            return ResponseHandler.respond("Successfully added a registration groups !", HttpStatus.OK, registrationGroup);
        } else {
            return ResponseHandler.respond("Null entities found", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "registrationgroups/{id}", consumes = "application/json")
    public ResponseEntity<?> updateRegistrationGroup(@PathVariable Long id, @RequestBody RegistrationGroupDto registrationGroupDto) {
        RegistrationGroup student = registrationGroupService.updateRegistrationGroup(id, registrationGroupDto);
        return ResponseHandler.respond("Successfully updated a registration groups!", HttpStatus.ACCEPTED, student);
    }

    @DeleteMapping("registrationgroups/{id}")
    public ResponseEntity<?> deleteRegistrationGroup(@PathVariable Long id) {
        registrationGroupService.removeRegistrationGroup(id);
        return ResponseHandler.respond("Successfully deleted a registration groups!", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("registrationgroups")
    public ResponseEntity<?> deleteRegistrationGroups() {
        registrationGroupService.removeRegistrationGroups();
        return ResponseHandler.respond("Successfully deleted a student!", HttpStatus.ACCEPTED);
    }


}
