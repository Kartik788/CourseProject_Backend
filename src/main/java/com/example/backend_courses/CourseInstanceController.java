package com.example.backend_courses;

import com.example.backend_courses.CourseInstance;
import com.example.backend_courses.CourseInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instances")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseInstanceController {

    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    @PostMapping
    public ResponseEntity<CourseInstance> createCourseInstance(@RequestBody CourseInstance courseInstance) {
        CourseInstance createdInstance = courseInstanceRepository.save(courseInstance);
        return ResponseEntity.ok(createdInstance);
    }

    @GetMapping("/{year}/{semester}")
    public ResponseEntity<List<CourseInstance>> listCourseInstances(@PathVariable Integer year, @PathVariable Integer semester) {
        List<CourseInstance> instances = courseInstanceRepository.findByCourseYearAndSemester(year, semester);
        return ResponseEntity.ok(instances);
    }

    @GetMapping("/{year}/{semester}/{id}")
    public ResponseEntity<CourseInstance> getCourseInstance(@PathVariable Integer year, @PathVariable Integer semester, @PathVariable Long id) {
        CourseInstance instance = courseInstanceRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(instance);
    }

    @DeleteMapping("/{year}/{semester}/{id}")
    public ResponseEntity<Void> deleteCourseInstance(@PathVariable Integer year, @PathVariable Integer semester, @PathVariable Long id) {
        courseInstanceRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}