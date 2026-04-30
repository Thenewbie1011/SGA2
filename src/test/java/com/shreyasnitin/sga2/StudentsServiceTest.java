package com.shreyasnitin.sga2;
import com.shreyasnitin.sga2.entity.Students;
import com.shreyasnitin.sga2.repository.StudentsRepository;
import com.shreyasnitin.sga2.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
//enables mockito support
@ExtendWith(MockitoExtension.class)
public class StudentsServiceTest {
    //We ONLY want to test the student service so we create a fake version of the students repo
    @Mock
    private StudentsRepository srepo;
    //create a real version of the students service and insert mock objects inside of it
    @InjectMocks
    private StudentService service;
    @Test
    void getAllStudents(){
        Students s=new Students();
        s.setStudent_name("Test");
        /*Without this, the fake repo is going to be empty. So this statement is crucial in inserting data into the fake repo */
        when(srepo.findAll()).thenReturn(List.of(s));
        List<Students> result=service.getAllStudents();
        assertEquals(1, result.size());
        assertEquals("Test", result.get(0).getStudent_name());
    }
    @Test
    void testSaveStudent(){
        Students s=new Students();
        s.setStudent_name("Shreyas");
        when(srepo.save(s)).thenReturn(s);
        Students result=service.createStudents(s);
        assertEquals("Shreyas", result.getStudent_name());
    }
    @Test
    void testFindStudentsByCourseName(){
        Students s=new Students();
        s.setStudent_name("Raiden");
        //we don't need to do anything with courses as the whole thing is fake, we just define that when this is run, a particular
        //output is given
        when(srepo.findStudentsByCourseName("Mathematics")).thenReturn(List.of(s));
        List<Students> result=service.getStudentsByCourseName("Mathematics");
        assertEquals(1, result.size());
        assertEquals("Raiden", result.get(0).getStudent_name());
    }

}