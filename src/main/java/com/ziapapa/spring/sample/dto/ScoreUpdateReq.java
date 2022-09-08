package com.ziapapa.spring.sample.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class ScoreUpdateReq {

    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private Integer score;

}
