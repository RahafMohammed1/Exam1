package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.Model.Student;
import com.example.schoolmanagementsystem.Model.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students=new ArrayList<>();
    public ArrayList<Student> getAll()
    {
        return students;
    }

    public boolean addStudent(Student student)
    {
        for(int i=0;i<students.size();i++)
        {
            if (students.get(i).getId()==student.getId())
            {
                return false;
            }
        }
        students.add(student);
        return true;
    }

    public boolean updateStudent(Integer id,Student student)
    {
        for(int i=0;i<students.size();i++)
        {
            if (students.get(i).getId()==id)
            {
                students.set(i,student);
                return true;
            }
        }
        return false;
    }
    public boolean deleteStudent(Integer id)
    {
        for(int i=0;i<students.size();i++)
        {
            if (students.get(i).getId()==id)
            {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(String name)
    {   Student student=null;
        for(int i=0;i<students.size();i++)
        {
            if (students.get(i).getName().equalsIgnoreCase(name))
            {
                student=students.get(i);
            }
        }
        return student;
    }


}
