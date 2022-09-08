package com.ziapapa.spring.sample.dto.data;

import com.ziapapa.spring.sample.type.SchoolType;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class StudentData {

    @NotNull
    @Size(min = 1, max = 16)
    private String name;

    @NotNull
    @Min(value = 8)
    @Max(value = 19)
    private int age;

    private SchoolType schoolType;

    @Pattern(regexp = "^\\d{3}-\\d{4}-\\d{4}$")
    private String phoneNumber;
}
