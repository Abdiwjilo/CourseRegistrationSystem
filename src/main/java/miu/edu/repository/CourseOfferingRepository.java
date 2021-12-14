package miu.edu.repository;

import miu.edu.model.Course;
import miu.edu.model.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Long> {
}