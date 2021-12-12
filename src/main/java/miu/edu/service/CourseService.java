package miu.edu.service;

import miu.edu.dto.CourseDto;
import miu.edu.model.Course;
import miu.edu.model.Faculty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Page<Course> findAll(Pageable pageable);
    Course findById(Long id);
    Course addCourse(CourseDto CourseDto);
    void removeCourse(Long id);
    void removeCourses();
    Course updateCourse(Long id, CourseDto courseDto);
}
