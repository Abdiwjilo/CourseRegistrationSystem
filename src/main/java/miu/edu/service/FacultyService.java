package miu.edu.service;

import miu.edu.dto.FacultyDto;
import miu.edu.model.Faculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FacultyService {
    List<Faculty> findAll();
    Page<Faculty> findAll(Pageable pageable);
    Faculty findById(Long id);
    Faculty addFaculty(FacultyDto facultyDto);
    void removeFaculty(Long id);
    void removeFaculties();
    Faculty updateFaculty(Long id, FacultyDto facultyDto);

}
