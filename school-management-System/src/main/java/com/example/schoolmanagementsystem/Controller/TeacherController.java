package com.example.schoolmanagementsystem.Controller;

import com.example.schoolmanagementsystem.ApiResponse.ApiResponse;
import com.example.schoolmanagementsystem.Model.Student;
import com.example.schoolmanagementsystem.Model.Teacher;
import com.example.schoolmanagementsystem.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/teacher")
public class TeacherController {
    TeacherService teacherService=new TeacherService() ;
    @GetMapping("/getall")
    public ResponseEntity getAll()
    {
        return ResponseEntity.status(200).body(teacherService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Teacher teacher, Errors erorrs) {
        if (erorrs.hasErrors()) {
            String message = erorrs.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(teacherService.addTeacher(teacher))
        {
            return ResponseEntity.status(200).body(new ApiResponse("The Teacher is added"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("The Teacher is already exist"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id ,@Valid @RequestBody Teacher teacher,Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (teacherService.updateTeacher(id, teacher)) {
            return ResponseEntity.status(200).body(new ApiResponse("The Teacher is updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("The Teacher is not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id )
    {
        if (teacherService.deleteTeacher(id))
        {
            return ResponseEntity.status(200).body(new ApiResponse("The Teacher is deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("The Teacher is not found"));
    }
    @GetMapping("/search/{id}")
    public ResponseEntity searchTeacher(@PathVariable Integer id )
    {
        Teacher teacherisFound=teacherService.searchTeacher(id);
        if(teacherisFound!=null)
        {
            return ResponseEntity.status(200).body(teacherisFound);
        }
        return ResponseEntity.status(400).body(new ApiResponse("The Teacher is not found"));
    }

}
