package com.ziapapa.spring.sample.entity;

import com.ziapapa.spring.sample.type.SchoolType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Table(name = "student")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private SchoolType schoolType;

    @Column
    private String phoneNumber;
}



