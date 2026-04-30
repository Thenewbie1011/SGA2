package com.shreyasnitin.sga2;
import com.shreyasnitin.sga2.entity.Courses;
import com.shreyasnitin.sga2.repository.CoursesRepository;
import com.shreyasnitin.sga2.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
@ExtendWith(MockitoExtension.class)
public class CoursesServiceTest {
    @Mock
    private CoursesRepository repo;
    @InjectMocks
    private CourseService service;
    @Test
    void testServiceNotNull() {
        assertNotNull(service);
    }
    @Test
    void getAllCourses(){
          Courses course = new Courses();
          course.setCourse_name("Mathematics");
          when(repo.findAll()).thenReturn(List.of(course));
          List<Courses> result=service.findAllCourses();
          assertEquals(1, result.size());
          assertEquals("Mathematics", result.get(0).getCourse_name());
    }
    @Test
    void testSaveCourse(){
        Courses course=new Courses();
        course.setCourse_name("Physics");
        when(repo.save(course)).thenReturn(course);
        Courses result=service.createCourses(course);
        assertEquals("Physics", result.getCourse_name());
    }
    @Test
    void testCourseById(){
        Courses course=new Courses();
        course.setCourse_id(5L);
        course.setCourse_name("History");
        //findById returns an optional data type, hence we need to use java.util.optional instead of List.of
        when(repo.findById(5L)).thenReturn(java.util.Optional.of(course));
        Courses result=service.getCourseById(5L);
        assertNotNull(result);
        assertEquals("History", result.getCourse_name());
    }
}