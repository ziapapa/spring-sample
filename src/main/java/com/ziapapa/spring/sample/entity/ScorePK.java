package com.ziapapa.spring.sample.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScorePK implements Serializable {

    private Long studentId;

    private Long subjectId;

}



