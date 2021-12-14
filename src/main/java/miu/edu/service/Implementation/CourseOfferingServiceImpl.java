package miu.edu.service.Implementation;

import miu.edu.dto.CourseDto;
import miu.edu.dto.CourseOfferingDto;
import miu.edu.model.Course;
import miu.edu.model.CourseOffering;
import miu.edu.repository.CourseOfferingRepository;
import miu.edu.service.CourseOfferingService;
import miu.edu.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CourseOfferingServiceImpl implements CourseOfferingService {

    @Autowired
    private CourseOfferingRepository courseOfferingRepository;

    @Override
    public List<CourseOffering> findAll() {
        return courseOfferingRepository.findAll();
    }

    @Override
    public Page<CourseOffering> findAll(Pageable pageable) {
        return courseOfferingRepository.findAll(pageable);
    }

    @Override
    public CourseOffering findById(Long id) {
        return courseOfferingRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CourseOffering with id " + id + " not found"));
    }


    @Override
    public void removeCourseOffering(Long id) {
        CourseOffering courseOffering = courseOfferingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CourseOffering with id " + id + " not found for deletion"));

        courseOfferingRepository.delete(courseOffering);
    }

    @Override
    public void removeCourseOfferings() {
        courseOfferingRepository.deleteAll();
    }

    @Override
    public  CourseOffering updateCourseOffering(Long id, CourseOfferingDto courseOfferingDto){
        CourseOffering courseOffering = courseOfferingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CourseOffering with id" + id + " not found for update"));

        courseOffering.setCode(courseOfferingDto.getCode());
        courseOfferingRepository.flush();
        return courseOffering;
    }


    @Override
    public CourseOffering addCourseOffering(CourseOfferingDto courseOfferingDto) {

        List<Course> courses = new ArrayList<>();

        for (CourseDto course:
              courseOfferingDto.getCourses()) {

            Course currentCourse = new Course();
            currentCourse.setCode(course.getCode());
            currentCourse.setName(course.getName());
            currentCourse.setDescription(course.getDescription());

            courses.add(currentCourse);
        }

        CourseOffering courseOffering = new CourseOffering();
        courseOffering.setCode(courseOfferingDto.getCode());
        courseOffering.setCapacity(courseOfferingDto.getCapacity());
        courseOffering.setCourses(courses);

        return courseOfferingRepository.save(courseOffering);
    }


}
