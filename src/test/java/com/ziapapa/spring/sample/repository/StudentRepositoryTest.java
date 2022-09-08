package com.ziapapa.spring.sample.repository;

import com.ziapapa.spring.sample.entity.StudentEntity;
import com.ziapapa.spring.sample.type.SchoolType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void save() {
        StudentEntity studentEntity =
                StudentEntity.builder()
                        .age(10)
                        .name("홍길동")
                        .phoneNumber("01011112222")
                        .schoolType(SchoolType.ELEMENTARY)
                        .build();
        studentRepository.save(studentEntity);

        StudentEntity resultEntity = studentRepository.findById(studentEntity.getId()).get();
        assertThat(studentEntity.getName()).isEqualTo(resultEntity.getName());
    }

    @Test
    void existsByPhoneNumber() {
        boolean result = studentRepository.existsByPhoneNumber("01011112222");
        assertThat(result).isTrue();
    }

    @Test
    void find() {
        StudentEntity studentEntity =
                StudentEntity.builder()
                        .age(10)
                        .name("홍길동")
                        .phoneNumber("01011112222")
                        .schoolType(SchoolType.ELEMENTARY)
                        .build();
        studentRepository.save(studentEntity);

        List<StudentEntity> studentEntityList = studentRepository.findAll();
        assertThat(studentEntityList.size()).isEqualTo(1);
    }
}