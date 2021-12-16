package miu.edu.service.Implementation;

import miu.edu.dto.*;
import miu.edu.model.*;
import miu.edu.repository.RegistrationEventRepository;
import miu.edu.service.RegistrationEventService;
import miu.edu.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RegistrationEventServiceImpl implements RegistrationEventService {

    @Autowired
    private RegistrationEventRepository registrationEventRepository;

    @Override
    public List<RegistrationEvent> findAll() {
        return registrationEventRepository.findAll();
    }

    @Override
    public Page<RegistrationEvent> findAll(Pageable pageable) {
        return registrationEventRepository.findAll(pageable);
    }

    @Override
    public RegistrationEvent findById(Long id) {
        return registrationEventRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RegistrationEvent with id " + id + " not found"));
    }

    @Override
    public void removeRegistrationEvent(Long id) {
        RegistrationEvent registrationEvent = registrationEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RegistrationEvent with id " + id + " not found for deletion"));

        registrationEventRepository.delete(registrationEvent);
    }

    @Override
    public  RegistrationEvent updateRegistrationEvent(Long id, RegistrationEventDto registrationEventDto){
        RegistrationEvent registrationEvent = registrationEventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RegistrationEvent with id" + id + " not found for update"));

        registrationEvent.setStartDate(registrationEventDto.getStartDate());
        registrationEvent.setEndDate(registrationEventDto.getEndDate());
        registrationEventRepository.flush();
        return registrationEvent;
    }

    @Override
    public List<RegistrationEvent> checkRegistrationEvent(){

        LocalDateTime now = LocalDateTime.now();
        return  registrationEventRepository.findRegistrationEventByStartDateLessThanAndEndDateGreaterThan(now, now);

    }

    @Override
    public RegistrationEvent addRegistrationEvent(RegistrationEventDto registrationEventDto) {

        List<RegistrationGroup> registrationGroups = new ArrayList<>();

        for (RegistrationGroupDto registrationGroupDto:
                registrationEventDto.getRegistrationGroups()) {


            List<Student> students = new ArrayList<>();

            for (StudentDto student :
                    registrationGroupDto.getStudents()) {

                Student currentStudent = new Student();
                currentStudent.setStudentId(student.getStudentId());
                currentStudent.setName(student.getName());
                currentStudent.setEmail(student.getEmail());
                currentStudent.setMailingAddress(student.getMailingAddress());
                currentStudent.setHomeAddress(student.getHomeAddress());

                students.add(currentStudent);
            }

            List<AcademicBlock> academicBlocks = new ArrayList<>();

            for (AcademicBlockDto academicBlock :
                    registrationGroupDto.getAcademicBlocks()) {

                AcademicBlock currentAcademicBlock = new AcademicBlock();
                currentAcademicBlock.setCode(academicBlock.getCode());
                currentAcademicBlock.setName(academicBlock.getName());
                currentAcademicBlock.setSemester(academicBlock.getSemester());
                currentAcademicBlock.setStartDate(academicBlock.getStartDate());
                currentAcademicBlock.setEndDate(academicBlock.getEndDate());

                List<Course> courses = new ArrayList<>();

                for (CourseDto courseDto :
                        academicBlock.getCourses()) {
                    Course course = new Course();
                    course.setName(courseDto.getName());
                    course.setCode(courseDto.getCode());
                    course.setDescription(courseDto.getDescription());
                    courses.add(course);
                }

                currentAcademicBlock.setCourses(courses);

                academicBlocks.add(currentAcademicBlock);
            }

            RegistrationGroup registrationGroup = new RegistrationGroup();
            registrationGroup.setStudents(students);
            registrationGroup.setAcademicBlocks(academicBlocks);

            registrationGroups.add(registrationGroup);
        }


        RegistrationEvent registrationEvent = new RegistrationEvent();
        registrationEvent.setStartDate(registrationEventDto.getStartDate());
        registrationEvent.setEndDate(registrationEventDto.getEndDate());
        registrationEvent.setRegistrationGroups(registrationGroups);

        return registrationEventRepository.save(registrationEvent);
    }


}
