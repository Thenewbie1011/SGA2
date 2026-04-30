package com.shreyasnitin.sga2.service;
import com.shreyasnitin.sga2.entity.Courses;
import com.shreyasnitin.sga2.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CourseService {
    @Autowired
    private CoursesRepository coursesRepository;
    //Creating a course
    public Courses createCourses(Courses course){
        return coursesRepository.save(course);
    }
    //Reading/retrieving the courses
    public List<Courses> findAllCourses(){
        return coursesRepository.findAll();
    }
    public Courses getCourseById(Long id){
    return coursesRepository.findById(id).orElse(null);
    }
    //updating the courses
    public Courses UpdateCourse(Courses course){
        return coursesRepository.save(course);
    }
}