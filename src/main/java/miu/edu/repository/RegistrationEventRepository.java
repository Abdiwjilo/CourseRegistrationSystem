package miu.edu.repository;

import miu.edu.model.RegistrationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
@Transactional
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent, Long>{
    RegistrationEvent findRegistrationEventByStartDateLessThanAndEndDateGreaterThan(LocalDateTime start, LocalDateTime end);
}
