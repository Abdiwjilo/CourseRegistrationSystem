package miu.edu.controller;

import miu.edu.dto.RegistrationEventDto;
import miu.edu.model.Course;
import miu.edu.model.RegistrationEvent;
import miu.edu.repository.RegistrationEventRepository;
import miu.edu.service.Implementation.RegistrationEventServiceImpl;
import miu.edu.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class RegistrationEventController {

    @Autowired
    RegistrationEventRepository registrationEventRepository;
    @Autowired
    RegistrationEventServiceImpl registrationEventService;


    @GetMapping(value = "/registrationevents")
    public List<RegistrationEvent> findAll() {
        return registrationEventService.findAll();
    }

    @GetMapping(value = "/registrationevents", params = "paged=true")
    public ResponseEntity<?> findAll(Pageable pageable) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, registrationEventService.findAll(pageable));
    }

    @GetMapping("/registrationevent/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, registrationEventService.findById(id));
    }

    @PostMapping("/registrationevents")
    public ResponseEntity<?> addRegistrationEvent(@RequestBody RegistrationEventDto registrationEventDto) {
        RegistrationEvent registrationEvent = registrationEventService.addRegistrationEvent(registrationEventDto);
        if (registrationEvent!= null) {
            return ResponseHandler.respond("Successfully added a registrationevent !", HttpStatus.OK, registrationEvent);
        } else {
            return ResponseHandler.respond("Null entities found", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "registrationevents/{id}", consumes = "application/json")
    public ResponseEntity<?> updateRegistrationEvent(@PathVariable Long id, @RequestBody RegistrationEventDto registrationEventDto) {
        RegistrationEvent registrationEvent = registrationEventService.updateRegistrationEvent(id, registrationEventDto);
        return ResponseHandler.respond("Successfully updated a registrationevent!", HttpStatus.ACCEPTED, registrationEvent);
    }

    @DeleteMapping("registrationevents/{id}")
    public ResponseEntity<?> deleteRegistrationEvent(@PathVariable Long id) {
        registrationEventService.removeRegistrationEvent(id);
        return ResponseHandler.respond("Successfully deleted a registrationevent!", HttpStatus.ACCEPTED);
    }

    @GetMapping("/registrationevent/latest")
    public ResponseEntity<?> checkRegistrationEvent(){
       return ResponseHandler.respond("Successfully added a registrationevent !", HttpStatus.OK,  registrationEventService.checkRegistrationEvent());
    }


}
