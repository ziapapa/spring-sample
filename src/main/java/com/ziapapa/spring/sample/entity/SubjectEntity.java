package com.ziapapa.spring.sample.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Table(name = "subject")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

}



