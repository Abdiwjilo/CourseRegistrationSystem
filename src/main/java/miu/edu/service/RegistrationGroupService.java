package miu.edu.service;

import miu.edu.dto.RegistrationGroupDto;
import miu.edu.model.RegistrationGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RegistrationGroupService {
    List<RegistrationGroup> findAll();
    Page<RegistrationGroup> findAll(Pageable pageable);
    RegistrationGroup findById(Long id);
    RegistrationGroup addRegistrationGroup(RegistrationGroupDto registrationGroupDto);
    void removeRegistrationGroup(Long id);
    void removeRegistrationGroups();
    RegistrationGroup updateRegistrationGroup(Long id, RegistrationGroupDto registrationGroupDto);
}
