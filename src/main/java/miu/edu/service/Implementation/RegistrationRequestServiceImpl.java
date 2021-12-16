package miu.edu.service.Implementation;

import miu.edu.dto.RegistrationRequestDto;
import miu.edu.dto.StudentDto;
import miu.edu.model.*;
import miu.edu.repository.RegistrationGroupRepository;
import miu.edu.repository.RegistrationRequestRepository;
import miu.edu.service.RegistrationRequestService;
import miu.edu.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RegistrationRequestServiceImpl implements RegistrationRequestService {


    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;
    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private AcademicBlockServiceImpl academicBlockService;
    @Autowired
    private CourseServiceImpl courseService;

    @Autowired
    private RegistrationGroupServiceImpl registrationGroupService;

    @Override
    public List<RegistrationRequest> findAll() {
        return registrationRequestRepository.findAll();
    }

    @Override
    public RegistrationRequest findById(Long id) {
        return registrationRequestRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registration Request with id " + id + " not found"));
    }


    Student student = null;
    AcademicBlock academicBlock = null;

    @Override
    public RegistrationRequest addRegistrationRequest(RegistrationRequestDto registrationRequestDto) throws Exception {
        RegistrationRequest requestDto = new RegistrationRequest();

        if (studentService.findById(registrationRequestDto.getStudentId()) != null){
            requestDto.setStudentId(registrationRequestDto.getStudentId());
        }

        if (academicBlockService.findById(registrationRequestDto.getAcademicBlockId()) != null){
            requestDto.setAcademicBlockId(registrationRequestDto.getAcademicBlockId());
        }

        List<Long> coursesIds = new ArrayList<>();

        for( Long courseId:
        registrationRequestDto.getCoursesId()) {
            if (courseService.findById(courseId) != null){
                coursesIds.add(courseId);
            } else{
                throw new Exception();
            }
        }

        requestDto.setCoursesId(coursesIds);

         for(RegistrationGroup registrationGroup: registrationGroupService.findAll()) {
             for(Student studentLoop: registrationGroup.getStudents()){
                 if(studentLoop.getId() == registrationRequestDto.getStudentId()){
                     student = studentLoop;
                 }
             }

             for(AcademicBlock academicBlockLoop: registrationGroup.getAcademicBlocks()){
                 if(academicBlockLoop.getId() == registrationRequestDto.getAcademicBlockId()){
                     academicBlock = academicBlockLoop;
                 }
             }


         }
         if (student != null && academicBlock != null) {
            return registrationRequestRepository.save(requestDto);
         }else{
           throw new Exception();
         }
    }


}