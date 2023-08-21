package com.example.hw21.Controller;

import com.example.hw21.Api.ApiResponse;
import com.example.hw21.Model.Course;
import com.example.hw21.Repository.CourseRepository;
import com.example.hw21.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    @GetMapping("/get")
    public ResponseEntity getAllCourses(){
      return ResponseEntity.status(200).body(courseService.getAllCourses()) ;
    }
    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("added"));

    }
@PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @RequestBody Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));

    }

    @PutMapping("/{teacherId}/assign/{courseId}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer teacherId, @PathVariable Integer courseId){
        courseService.assignTeacherToCourse(teacherId,courseId);
        return ResponseEntity.status(200).body(new ApiResponse("assigned"));
    }
    @GetMapping("/getteachername/{courseId}")
    public ResponseEntity getTeacherName(@PathVariable Integer courseId){
        return ResponseEntity.status(200).body(courseService.getTeacherOfTheCourse(courseId));
    }
}
