package miu.edu.repository;

import miu.edu.model.RegistrationEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent, Long>{
    List<RegistrationEvent> findRegistrationEventByStartDateLessThanAndEndDateGreaterThan(LocalDateTime start, LocalDateTime end);
}
