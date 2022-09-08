package com.ziapapa.spring.sample.dto;

import com.ziapapa.spring.sample.dto.data.SubjectData;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SubjectSaveReq {

    private SubjectData subject;
}
