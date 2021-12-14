package miu.edu.service.Implementation;

import miu.edu.dto.RegistrationEventDto;
import miu.edu.dto.RegistrationGroupDto;
import miu.edu.model.Course;
import miu.edu.model.RegistrationEvent;
import miu.edu.model.RegistrationGroup;
import miu.edu.repository.RegistrationEventRepository;
import miu.edu.service.RegistrationEventService;
import miu.edu.util.exception.ResourceNotFoundException;
import org.apache.tomcat.jni.Local;
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
    public RegistrationEvent addRegistrationEvent(RegistrationEventDto registrationEventDto) {

//       List<RegistrationGroup> registrationGroups = new ArrayList<>();
//
//       for (RegistrationGroupDto registrationGroup :
//               registrationEventDto.getRegistrationGroups()){
//           RegistrationGroup currentRegistrationGroup = new RegistrationGroup();
//           currentRegistrationGroup.setStudents(
//
//           );
//
//       }

        RegistrationEvent registrationEvent = new RegistrationEvent();

        registrationEvent.setStartDate(registrationEventDto.getStartDate());
        registrationEvent.setEndDate(registrationEventDto.getEndDate());
        return registrationEventRepository.save(registrationEvent);

    }


    @Override
    public RegistrationEvent checkRegistrationEvent(){
        LocalDateTime now = LocalDateTime.now();
        return registrationEventRepository.findRegistrationEventByStartDateLessThanAndEndDateGreaterThan(now, now);

    }

//    @Override
//    public List<Subassignment> checkRegistrationEvent(long id, LocalDateTime startDateTime, LocalDateTime endDateTime) {
//        return getEntityManager().createNamedQuery("ResourceVO.findByAssignmentIdAndDates", Subassignment.class)
//                .setParameter("id", id)
//                .setParameter("sdt", startDateTime)
//                .setParameter("edt", endDateTime)
//                .getResultList();
//    }
//<named-query name='ResourceVO.findByAssignmentIdAndDates'>
//    <query>
//    SELECT c FROM Subassignment AS c
//    WHERE (c.assignmentId IN (SELECT b.id FROM Assignment b WHERE b.resource.id = :id))
//    AND (c.startDateTime BETWEEN :sdt AND :edt)
//
//    </query>
//</named-query>
}
