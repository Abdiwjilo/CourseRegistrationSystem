package miu.edu.service.Implementation;

import miu.edu.dto.CourseDto;
import miu.edu.model.Course;
import miu.edu.model.Student;
import miu.edu.repository.CourseRepository;
import miu.edu.service.CourseService;
import miu.edu.util.exception.ResourceNotFoundException;
import miu.edu.util.exception.StudentCourseIllegalStateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final static Logger LOG = LoggerFactory.getLogger(CourseService.class);
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Page<Course> findAll(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }

    @Override
    public Course findById(Long id) {
        return courseRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id " + id + " not found"));
    }


    @Override
    public void removeCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with id " + id + " not found for deletion"));

        courseRepository.delete(course);
    }

    @Override
    public void removeCourses() {
        courseRepository.deleteAll();
    }

    @Override
    public Course updateCourse(Long id, CourseDto courseDto){
        Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course with id" + id + " not found for update"));

        course.setCode(courseDto.getCode());
        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        courseRepository.flush();
        return course;
    }


    @Override
    public Course addCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setCode(courseDto.getCode());
        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        return courseRepository.save(course);
    }


}
