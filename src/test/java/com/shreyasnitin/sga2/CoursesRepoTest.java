package com.shreyasnitin.sga2;
import com.shreyasnitin.sga2.entity.Courses;
import com.shreyasnitin.sga2.entity.Students;
import com.shreyasnitin.sga2.repository.CoursesRepository;
import com.shreyasnitin.sga2.repository.StudentsRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
@SpringBootTest
public class CoursesRepoTest {
    @Autowired
    private CoursesRepository crepo;
    @Autowired
    private StudentsRepository srepo;
    @Test
    void testRepositoryInjection() {
        assertNotNull(crepo);
    }
    @Test
    void testSaveCourse(){
        Courses course=new Courses();
        course.setCourse_name("Mathematics");
        course.setCourse_credits(4);
        Courses saved=crepo.save(course);
        assertNotNull(saved);
    }
    @Test
    @Transactional
    /*Transactional is used here as by default, manytomany is LAZY. When a course is fetched, hibernate does not load the student
    list automatically. Only when fetched.getstudents() runs, is the student list loaded. Without that, it isn't. So after course
    is fetched, the session is closed and retrieving results in an error. Using @Transactional, the session still remains open 
    and the student list is fetched */
    void StudentCourseRelationship(){
        Courses course=new Courses();
        course.setCourse_name("Physics");
        course.setCourse_credits(4);
        Courses saved=crepo.save(course);

        Students student=new Students();
        student.setStudent_name("Yelan");
        student.setStudent_email("yelan_sample@gmail.com");
        student.setStudent_gender("Female");
        student.setStudent_age(30);
        student.setCourses(List.of(saved));
        saved.setStudents(List.of(student));
        srepo.save(student);
        //going back to the database to check if data is actually stored in db
        Courses fetched=crepo.findById(saved.getCourse_id()).orElse(null);
        assertNotNull(fetched);
        assertFalse(fetched.getStudents().isEmpty());
    }
}