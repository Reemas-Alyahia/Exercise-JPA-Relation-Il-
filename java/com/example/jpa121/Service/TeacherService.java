package com.example.jpa121.Service;

import com.example.jpa121.ApiResponse.ApiException;
import com.example.jpa121.Model.Address;
import com.example.jpa121.Model.Teacher;
import com.example.jpa121.Repository.AddressRepository;
import com.example.jpa121.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;
    public List<Teacher> getALLTeacher(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Teacher teacher,Integer id){
        Teacher teacher1=teacherRepository.findTeacherById(id);
        if(teacher1==null){
            throw new ApiException("Teacher cannot found ");
        }
        teacher1.setAddress(teacher.getAddress());
        teacher1.setAge(teacher.getAge());
        teacher1.setName(teacher.getName());
        teacher1.setSalary(teacher.getSalary());
        teacher1.setEmail(teacher.getEmail());

        teacherRepository.save(teacher1);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("Teacher cannot found ");
        }
        Address address=addressRepository.findAddressById(id);
        teacher.setAddress(null);

        addressRepository.delete(address);
        teacherRepository.delete(teacher);
    }

//Create endpoint that takes teacher id and return All
//teacher details
    public Teacher getByTeacherId(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("Teacher cannot found ");
        }
        return teacher;
    }


}
