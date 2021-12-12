package miu.edu.service.Implementation;

import miu.edu.dto.FacultyDto;
import miu.edu.model.Faculty;
import miu.edu.repository.FacultyRepository;
import miu.edu.service.FacultyService;
import miu.edu.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Page<Faculty> findAll(Pageable pageable) {
        return facultyRepository.findAll(pageable);
    }

    @Override
    public Faculty findById(Long id) {
        return facultyRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty with id " + id + " not found"));
    }


    @Override
    public void removeFaculty(Long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Faculty with id " + id + " not found for deletion"));

        facultyRepository.delete(faculty);
    }

    @Override
    public void removeFaculties() {
       facultyRepository.deleteAll();
    }

    @Override
    public  Faculty updateFaculty(Long id, FacultyDto facultyDto){
       Faculty faculty = facultyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("faculty with id" + id + " not found for update"));

        faculty.setName(facultyDto.getName());
        faculty.setEmail(facultyDto.getEmail());
        faculty.setTitle(facultyDto.getTitle());
        facultyRepository.flush();
        return faculty;
    }


    @Override
    public Faculty addFaculty(FacultyDto facultyDto) {
        Faculty faculty = new Faculty();
        faculty.setName(facultyDto.getName());
        faculty.setEmail(facultyDto.getEmail());
        faculty.setTitle(facultyDto.getTitle());
        return facultyRepository.save(faculty);
    }

}
