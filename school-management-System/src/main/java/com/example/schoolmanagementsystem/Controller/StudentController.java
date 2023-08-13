package com.example.schoolmanagementsystem.Controller;

import com.example.schoolmanagementsystem.ApiResponse.ApiResponse;
import com.example.schoolmanagementsystem.Model.Student;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/student")
public class StudentController {
    StudentService studentService=new StudentService();
    @GetMapping("/getall")
    public ResponseEntity getAll()
    {
        return ResponseEntity.status(200).body(studentService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors erorrs)
    {
        if(erorrs.hasErrors()){
            String message=erorrs.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(studentService.addStudent(student))
        {
            return ResponseEntity.status(200).body(new ApiResponse("The Student is added"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("The Student is already exist"));
    }

   @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id ,@Valid @RequestBody Student student,Errors errors)
   {
       if(errors.hasErrors()){
           String message=errors.getFieldError().getDefaultMessage();
           return ResponseEntity.status(400).body(message);
       }
       if(studentService.updateStudent(id,student))
       {
           return ResponseEntity.status(200).body(new ApiResponse("The Student is updated"));
       }
       return ResponseEntity.status(400).body(new ApiResponse("The Student is not found"));
   }
   @DeleteMapping("/delete/{id}")
   public ResponseEntity deleteStudent(@PathVariable Integer id )
   {
       if (studentService.deleteStudent(id))
       {
           return ResponseEntity.status(200).body(new ApiResponse("The Student is deleted"));
       }
       return ResponseEntity.status(400).body(new ApiResponse("The Student is not found"));
   }
    @GetMapping("/search/{name}")
    public ResponseEntity searchTeacher(@PathVariable String name)
    {
        System.out.print(name);
        Student studentIsFound=studentService.searchStudent(name);
        if(studentIsFound!=null)
        {
            return ResponseEntity.status(200).body(studentIsFound);
        }
        return ResponseEntity.status(400).body(new ApiResponse("The Student is not found"));
    }


}
