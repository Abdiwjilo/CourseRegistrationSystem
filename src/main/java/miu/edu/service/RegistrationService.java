package miu.edu.service;

import miu.edu.model.Registration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RegistrationService {
    List<Registration> findAll();
    Page<Registration> findAll(Pageable pageable);
    Registration processRegistration(long id);
}
