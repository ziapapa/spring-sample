package com.ziapapa.spring.sample.dto.data;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SubjectData {

    @NotNull
    @Size(min = 1, max = 12)
    private String name;

}
