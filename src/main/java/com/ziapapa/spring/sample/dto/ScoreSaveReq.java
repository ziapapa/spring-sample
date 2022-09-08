package com.ziapapa.spring.sample.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class ScoreSaveReq {

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private Integer score;

}
