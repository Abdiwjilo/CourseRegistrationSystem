package miu.edu.service.Implementation;

import miu.edu.dto.*;
import miu.edu.model.*;
import miu.edu.repository.RegistrationGroupRepository;
import miu.edu.service.RegistrationGroupService;
import miu.edu.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RegistrationGroupServiceImpl implements RegistrationGroupService {


    @Autowired
    private RegistrationGroupRepository registrationGroupRepository;

    @Override
    public List<RegistrationGroup> findAll() {
        return registrationGroupRepository.findAll();
    }

    @Override
    public Page<RegistrationGroup> findAll(Pageable pageable) {
        return registrationGroupRepository.findAll(pageable);
    }

    @Override
    public RegistrationGroup findById(Long id) {
        return registrationGroupRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RegistrationGroup with id " + id + " not found"));
    }

    @Override
    public void removeRegistrationGroup(Long id) {
        RegistrationGroup registrationGroup = registrationGroupRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RegistrationGroup with id " + id + " not found for deletion"));

        registrationGroupRepository.delete(registrationGroup);
    }

    @Override
    public void removeRegistrationGroups() {registrationGroupRepository.deleteAll();}

    @Override
    public  RegistrationGroup updateRegistrationGroup(Long id, RegistrationGroupDto registrationGroupDto){
        RegistrationGroup registrationGroup = registrationGroupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RegistrationGroup with id" + id + " not found for update"));

        registrationGroup.setStudents(registrationGroup.getStudents());
        registrationGroup.setAcademicBlocks(registrationGroup.getAcademicBlocks());
        registrationGroupRepository.flush();
        return registrationGroup;
    }
    @Override
    public RegistrationGroup addRegistrationGroup(RegistrationGroupDto registrationGroupDto) {

        List<Student> students = new ArrayList<>();

        for (StudentDto student:
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

        for (AcademicBlockDto academicBlock:
                registrationGroupDto.getAcademicBlocks()) {

            AcademicBlock currentAcademicBlock = new AcademicBlock();
            currentAcademicBlock.setCode(academicBlock.getCode());
            currentAcademicBlock.setName(academicBlock.getName());
            currentAcademicBlock.setSemester(academicBlock.getSemester());
            currentAcademicBlock.setStartDate(academicBlock.getStartDate());
            currentAcademicBlock.setEndDate(academicBlock.getEndDate());

            academicBlocks.add(currentAcademicBlock);
        }

        RegistrationGroup registrationGroup = new RegistrationGroup();

        return registrationGroupRepository.save(registrationGroup);

    }




}
