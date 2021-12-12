package miu.edu.repository;

import miu.edu.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByStudentId(String studentId);
}