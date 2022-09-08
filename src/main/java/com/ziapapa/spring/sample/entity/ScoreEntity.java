package com.ziapapa.spring.sample.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "score")
@Entity
@IdClass(ScorePK.class)
public class ScoreEntity {

    @Id
    private Long studentId;

    @Id
    private Long subjectId;

    @Column
    private Integer score;

}



