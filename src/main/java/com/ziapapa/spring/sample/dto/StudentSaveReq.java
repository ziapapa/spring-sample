package com.ziapapa.spring.sample.dto;

import com.ziapapa.spring.sample.dto.data.StudentData;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;

@Getter
@Setter
@ToString
public class StudentSaveReq {

    @Valid
    private StudentData student;

}
