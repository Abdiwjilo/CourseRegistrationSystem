package miu.edu.controller;

import miu.edu.dto.FacultyDto;
import miu.edu.dto.RegistrationRequestDto;
import miu.edu.model.Faculty;
import miu.edu.model.RegistrationRequest;
import miu.edu.repository.CourseRepository;
import miu.edu.repository.RegistrationRequestRepository;
import miu.edu.service.Implementation.CourseServiceImpl;
import miu.edu.service.Implementation.RegistrationRequestServiceImpl;
import miu.edu.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationRequestController {

    @Autowired
    RegistrationRequestRepository registrationRequestRepository;
    @Autowired
    RegistrationRequestServiceImpl registrationRequestService;



    @PostMapping("/registrationrequest")
    public ResponseEntity<?> addRegistrationRequest(@RequestBody RegistrationRequestDto registrationRequestDto) {
        RegistrationRequest registrationRequest = registrationRequestService.addRegistrationRequest(registrationRequestDto);
        if (registrationRequest!= null) {
            return ResponseHandler.respond("Successfully apply for registration request!", HttpStatus.OK, registrationRequest);
        } else {
            return ResponseHandler.respond("Null entities found", HttpStatus.BAD_REQUEST);
        }
    }

}
