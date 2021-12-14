package miu.edu.service;

import miu.edu.dto.CourseOfferingDto;
import miu.edu.model.CourseOffering;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseOfferingService {
    List<CourseOffering> findAll();
    Page<CourseOffering> findAll(Pageable pageable);
    CourseOffering findById(Long id);
    CourseOffering addCourseOffering(CourseOfferingDto courseOfferingDto);
    void removeCourseOffering(Long id);
    void removeCourseOfferings();
    CourseOffering updateCourseOffering(Long id, CourseOfferingDto courseOfferingDto);
}
