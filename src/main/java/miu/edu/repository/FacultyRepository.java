package miu.edu.repository;

import miu.edu.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}
