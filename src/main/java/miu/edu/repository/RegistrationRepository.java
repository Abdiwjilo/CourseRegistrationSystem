package miu.edu.repository;

import miu.edu.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
