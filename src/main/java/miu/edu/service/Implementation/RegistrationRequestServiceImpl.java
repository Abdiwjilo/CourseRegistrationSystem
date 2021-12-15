package miu.edu.service.Implementation;

import miu.edu.dto.RegistrationRequestDto;
import miu.edu.dto.StudentDto;
import miu.edu.model.Faculty;
import miu.edu.model.RegistrationRequest;
import miu.edu.model.Student;
import miu.edu.repository.RegistrationGroupRepository;
import miu.edu.repository.RegistrationRequestRepository;
import miu.edu.service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RegistrationRequestServiceImpl implements RegistrationRequestService {


    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Student findById(Long id) {
        return null;
    }

    @Override
    public RegistrationRequest addRegistrationRequest(RegistrationRequestDto registrationRequestDto) {
        RegistrationRequest requestDto = new RegistrationRequest();
        requestDto.setStudentId(registrationRequestDto.getStudentId());
        requestDto.setAcademicBlockId(registrationRequestDto.getAcademicBlockId());
        requestDto.setCoursesId(registrationRequestDto.getCoursesId());
        return registrationRequestRepository.save(requestDto);
    }

    @Override
    public void removeStudent(Long id) {

    }

    @Override
    public void removeStudents() {

    }

    @Override
    public Student updateStudent(Long id, StudentDto studentDto) {
        return null;
    }
}
