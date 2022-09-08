package com.ziapapa.spring.sample.repository;

import com.ziapapa.spring.sample.entity.ScorePK;
import com.ziapapa.spring.sample.repository.dto.StudentScore;
import com.ziapapa.spring.sample.repository.dto.SubjectScore;
import com.ziapapa.spring.sample.entity.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, ScorePK> {

    @Query(nativeQuery = true, value = "SELECT AVG(score) FROM score WHERE student_id = :studentId")
    public Long averageScoreByStudentId(@Param("studentId") Long studentId);

    @Query(nativeQuery = true, value =
            "SELECT sj.id, sj.name, s.score" +
            "  FROM subject sj, score s" +
            "  WHERE sj.id = s.subject_id" +
            "    AND s.student_id = :studentId")
    public List<SubjectScore> findSubjectScoreByStudentId(@Param("studentId") Long studentId);

    @Query(nativeQuery = true, value = "SELECT AVG (score) FROM score WHERE subject_id = :subjectId")
    public Long averageScoreBySubjectId(@Param("subjectId") Long subjectId);

    @Query(nativeQuery = true, value =
            "SELECT st.id, st.name, s.score" +
            "  FROM student st, score s" +
            "  WHERE st.id = s.student_id" +
            "    AND s.subject_id = :subjectId")
    public List<StudentScore> findStudentScoreBySubjectId(@Param("subjectId") Long subjectId);
}
