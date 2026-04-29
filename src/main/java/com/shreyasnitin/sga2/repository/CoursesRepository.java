package com.shreyasnitin.sga2.repository;
import com.shreyasnitin.sga2.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CoursesRepository extends JpaRepository<Courses,Long> {
    
}
