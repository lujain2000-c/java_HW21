package com.example.hw21.Service;

import com.example.hw21.Api.ApiException;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;


    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){

        teacherRepository.save(teacher);

    }

    public void updateTeacher(Integer id,Teacher teacher){
        Teacher teacher1 = teacherRepository.findTeacherById(id);

        if (teacher1 == null){
            throw new ApiException("not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);

    }

    public void deleteTeacher(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher == null){
            throw new ApiException("not foound");
        }

        teacherRepository.delete(teacher);
    }
}
