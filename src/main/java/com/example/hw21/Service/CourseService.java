package com.example.hw21.Service;

import com.example.hw21.Api.ApiException;
import com.example.hw21.Model.Course;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repository.CourseRepository;
import com.example.hw21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

     public List<Course> getAllCourses(){
         return courseRepository.findAll();
     }

     public void addCourse(Course course){
         courseRepository.save(course);
     }

     public void updateCourse(Integer id, Course course){
        Course course1 = courseRepository.findCourseById(id);
         if(course1 == null){
             throw new ApiException("not found");
         }
         course1.setName(course.getName());
         courseRepository.save(course1);
     }

     public void deleteCourse(Integer id){
         Course course1 = courseRepository.findCourseById(id);
         if(course1 == null){
             throw new ApiException("not found");
         }
         courseRepository.delete(course1);

     }

     public void assignTeacherToCourse(Integer teacherId, Integer courseId){
         Teacher teacher = teacherRepository.findTeacherById(teacherId);
         Course course = courseRepository.findCourseById(courseId);
         if(teacher == null || course == null){
             throw new ApiException("not found teacher or course");
         }

         course.setTeacher(teacher);
         courseRepository.save(course);
     }

     public String getTeacherOfTheCourse(Integer courseId){
         Course course = courseRepository.findCourseById(courseId);

         if(course == null){
             throw new ApiException("not found course");
         }
         String teacherName = course.getTeacher().getName();
         return teacherName;
     }
}
