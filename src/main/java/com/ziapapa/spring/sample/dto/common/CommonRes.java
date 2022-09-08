package com.ziapapa.spring.sample.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonRes {

    private Map<String, Object> data;

    private ErrorRes error;

}
