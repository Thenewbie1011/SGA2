package com.shreyasnitin.sga2.service;
import com.shreyasnitin.sga2.entity.Students;
import com.shreyasnitin.sga2.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentsRepository studentsRepository;

    //Creation
    public Students createStudents(Students student){
        return studentsRepository.save(student);
    }
    //Reading (Retrieves all the students)
    public List<Students> getAllStudents(){
        return studentsRepository.findAll();
    }
    //Reading (retrieves students for a particular course name)
    public List<Students> getStudentsByCourseName(String courseName){
        return studentsRepository.findStudentsByCourseName(courseName);
    }
    //Update
    public Students updateStudent(Students student){
        return studentsRepository.save(student);
    }
    //Getting students by primary key (student_id)
    public Students getStudentsById(Long id){
        return studentsRepository.findById(id).orElse(null);
    }
}