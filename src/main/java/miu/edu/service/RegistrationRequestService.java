package miu.edu.service;

import miu.edu.dto.RegistrationRequestDto;
import miu.edu.model.Course;
import miu.edu.model.RegistrationRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RegistrationRequestService {
    List<RegistrationRequest> findAll();
    RegistrationRequest findById(Long id);
    RegistrationRequest addRegistrationRequest(RegistrationRequestDto registrationRequestDto) throws Exception;

}
