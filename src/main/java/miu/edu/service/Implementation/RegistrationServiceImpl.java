package miu.edu.service.Implementation;

import miu.edu.model.*;
import miu.edu.repository.RegistrationRepository;
import miu.edu.repository.RegistrationRequestRepository;
import miu.edu.service.CourseService;
import miu.edu.service.RegistrationService;
import miu.edu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    @Autowired
    RegistrationRequestRepository registrationRequestRepository;

    @Autowired
    RegistrationRepository registrationRepository;

    @Override
    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }

    @Override
    public Page<Registration> findAll(Pageable pageable) {
        return registrationRepository.findAll(pageable);
    }

    @Override
    public Registration processRegistration(long id) {

        RegistrationRequest registrationRequest = registrationRequestRepository.getById(id);

        Registration registration = new Registration();

        List<Course> courses = new ArrayList<>();
        for (Long courseId:
                registrationRequest.getCoursesId() ) {
            courses.add(courseService.findById(courseId));
        }

        registration.setCourses(courses);
        registration.setStudents(studentService.findById(registrationRequest.getStudentId()));
        return   registrationRepository.save(registration);
    }



}
