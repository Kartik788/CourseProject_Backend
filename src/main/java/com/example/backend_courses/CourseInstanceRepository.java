package com.example.backend_courses;

import com.example.backend_courses.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {
    List<CourseInstance> findByCourseYearAndSemester(Integer courseYear, Integer semester);
}
