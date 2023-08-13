package com.example.schoolmanagementsystem.Service;

import com.example.schoolmanagementsystem.Model.Student;
import com.example.schoolmanagementsystem.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher> teachers=new ArrayList<>();
    public ArrayList<Teacher> getAll()
    {
        return teachers;
    }
    public boolean addTeacher(Teacher teacher)
    {
        for(int i=0;i<teachers.size();i++)
        {
            if (teachers.get(i).getId()==teacher.getId())
            {
                return false;
            }
        }
        teachers.add(teacher);
        return true;
    }
    public boolean updateTeacher(Integer id,Teacher teacher)
    {
        for(int i=0;i<teachers.size();i++)
        {
            if (teachers.get(i).getId()==id)
            {
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }
    public boolean deleteTeacher(Integer id)
    {
        for(int i=0;i<teachers.size();i++)
        {
            if (teachers.get(i).getId()==id)
            {
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean checkTeacher(Integer id)
    {
        for(int i=0;i<teachers.size();i++)
        {
            if (teachers.get(i).getId()==id)
            {
                return true;
            }
        }
        return false;
    }
    public Teacher searchTeacher(Integer id)
    {   Teacher teacher=null;
        for(int i=0;i<teachers.size();i++)
        {
            if (teachers.get(i).getId()==id)
            {
               teacher=teachers.get(i);
            }
        }
        return teacher;
    }

}
