package com.ziapapa.spring.sample.repository;

import com.ziapapa.spring.sample.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    boolean existsByPhoneNumber(String phoneNumber);
}
