package com.shreyasnitin.sga2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.shreyasnitin.sga2.entity.Students;
import com.shreyasnitin.sga2.entity.Courses;
import com.shreyasnitin.sga2.repository.CoursesRepository;
import com.shreyasnitin.sga2.repository.StudentsRepository;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
@SpringBootTest
public class StudentsRepoTest {
@Autowired
    private StudentsRepository repo;
@Autowired
    private CoursesRepository crepo;
    @Test
    void testRepositoryInjection() {
        assertNotNull(repo);
    }
    @Test
    void testSaveStudent() {
        Students s = new Students();
        s.setStudent_name("SN");
        s.setStudent_email("sn_sample@gmail.com");
        s.setStudent_gender("Male");
        s.setStudent_age(20);

        Students saved = repo.save(s);

        assertNotNull(saved.getStudent_id());
    }
    @Test
    void testFindStudentsByCourseName(){
        Courses course=new Courses();
        course.setCourse_name("Mathematics");
        course.setCourse_credits(4);
        Courses savedCourse=crepo.save(course);

        Students student=new Students();
        student.setStudent_name("Shreyas");
        student.setStudent_email("nshreyas08@gmail.com");
        student.setStudent_gender("Male");
        student.setStudent_age(20);
        student.setCourses(List.of(savedCourse));
        repo.save(student);

        List <Students> result=repo.findStudentsByCourseName("Mathematics");
        assertFalse(result.isEmpty());
        assertEquals("Shreyas", result.get(0).getStudent_name());
    }
}