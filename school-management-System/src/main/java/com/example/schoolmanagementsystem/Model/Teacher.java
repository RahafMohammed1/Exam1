package com.example.schoolmanagementsystem.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull(message = "The id field is required")
    private Integer id;
    @NotEmpty(message ="The name field is required" )
    private String name;
    @NotNull(message = "The salary field is required")
    private Integer salary;
}
