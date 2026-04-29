package com.shreyasnitin.sga2.repository;
import com.shreyasnitin.sga2.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface StudentsRepository extends JpaRepository<Students,Long>{

    //custom query INNER JOIN
    @Query("SELECT s FROM Students s JOIN s.courses c WHERE c.course_name=:courseName")
    List<Students> findStudentsByCourseName(@Param("courseName") String courseName);
    
}
