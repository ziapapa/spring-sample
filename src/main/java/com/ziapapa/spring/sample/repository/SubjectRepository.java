package com.ziapapa.spring.sample.repository;

import com.ziapapa.spring.sample.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {

    boolean existsByName(String name);

}
