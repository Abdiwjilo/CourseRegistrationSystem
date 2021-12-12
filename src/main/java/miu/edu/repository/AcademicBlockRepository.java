package miu.edu.repository;

import miu.edu.model.AcademicBlock;
import miu.edu.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AcademicBlockRepository extends JpaRepository<AcademicBlock, Long> {
    List<Course> findByCode(String code);
}

