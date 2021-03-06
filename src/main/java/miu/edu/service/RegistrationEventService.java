package miu.edu.service;

import miu.edu.dto.RegistrationEventDto;
import miu.edu.dto.RegistrationGroupDto;
import miu.edu.model.RegistrationEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RegistrationEventService {

    List<RegistrationEvent> findAll();
    Page<RegistrationEvent> findAll(Pageable pageable);
    RegistrationEvent findById(Long id);
    RegistrationEvent addRegistrationEvent(RegistrationEventDto registrationEventDto);
    void removeRegistrationEvent(Long id);
    RegistrationEvent updateRegistrationEvent(Long id, RegistrationEventDto registrationEventDto);
    List<RegistrationEvent> checkRegistrationEvent();
//    List<RegistrationEvent> checkRegistrationEventForStudentId();
    //RegistrationEvent addRegistrationGroupFromEvent(RegistrationGroupDto registrationGroupDto);
}
