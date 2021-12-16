package miu.edu.controller;

import miu.edu.model.Registration;
import miu.edu.model.RegistrationRequest;
import miu.edu.repository.RegistrationRepository;
import miu.edu.repository.RegistrationRequestRepository;
import miu.edu.service.Implementation.RegistrationRequestServiceImpl;
import miu.edu.service.Implementation.RegistrationServiceImpl;
import miu.edu.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {


    @Autowired
    RegistrationRepository registrationRepository;
    @Autowired
    RegistrationServiceImpl registrationService;
    @Autowired
    RegistrationRequestRepository registrationRequestRepository;
    @Autowired
    RegistrationRequestServiceImpl registrationRequestService;


    @GetMapping(value = "/registrations")
    public List<RegistrationRequest> findAll() {
        return registrationRequestService.findAll();
    }


    @PostMapping("registration/registrationrequest/{id}")
    public ResponseEntity<?> processRegistration(@PathVariable Long id) {
        registrationService.processRegistration(id);
        return ResponseHandler.respond("Successfully registered to a course!", HttpStatus.ACCEPTED);
    }
}
