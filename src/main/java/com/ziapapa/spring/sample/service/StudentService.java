package com.ziapapa.spring.sample.service;

import com.ziapapa.spring.sample.dto.StudentSaveReq;
import com.ziapapa.spring.sample.entity.StudentEntity;
import com.ziapapa.spring.sample.repository.dto.SubjectScore;
import com.ziapapa.spring.sample.dto.common.CommonRes;
import com.ziapapa.spring.sample.entity.ScoreEntity;
import com.ziapapa.spring.sample.exception.BusinessException;
import com.ziapapa.spring.sample.exception.ErrorCode;
import com.ziapapa.spring.sample.repository.ScoreRepository;
import com.ziapapa.spring.sample.repository.StudentRepository;
import com.ziapapa.spring.sample.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Service
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;
    private final SubjectService subjectService;

    public CommonRes saveStudent(StudentSaveReq studentSaveReq) {

        CommonRes commonRes = new CommonRes();

        String phoneNumber = studentSaveReq.getStudent().getPhoneNumber();
        if (studentRepository.existsByPhoneNumber(phoneNumber))
            throw new BusinessException(ErrorCode.ALREADY_EXIST_STUDENT, phoneNumber);

        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(studentSaveReq.getStudent(), studentEntity);
        studentRepository.save(studentEntity);

        return commonRes;
    }

    public CommonRes findStudents() {

        CommonRes commonRes = new CommonRes();

        List<StudentEntity> studentEntityList = studentRepository.findAll();

        Map<String, Object> map = new HashMap<>();
        map.put("students", studentEntityList);
        commonRes.setData(map);

        return commonRes;
    }

    public void deleteStudent(Long id) {

        try {
            studentRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            // either do nothing to return a 204, or throw new NotFoundException();
        }
        return;
    }

    public CommonRes saveScore(Long studentId, Long subjectId, Integer score ) {

        CommonRes commonRes = new CommonRes();

        existsByStudentId(studentId);
        subjectService.existsBySubjectId(subjectId);

        ScoreEntity scoreEntity = new ScoreEntity(studentId, subjectId, score);
        scoreRepository.save(scoreEntity);

        return commonRes;
    }

    public CommonRes updateScore(Long studentId, Long subjectId, Integer score ) {

        CommonRes commonRes = new CommonRes();

        existsByStudentId(studentId);
        subjectService.existsBySubjectId(subjectId);

        ScoreEntity scoreEntity = new ScoreEntity(studentId, subjectId, score);
        scoreRepository.save(scoreEntity);

        return commonRes;
    }

    public CommonRes deleteScore(Long studentId, Long subjectId ) {

        CommonRes commonRes = new CommonRes();

        existsByStudentId(studentId);
        subjectService.existsBySubjectId(subjectId);

        ScoreEntity scoreEntity = new ScoreEntity();
        scoreEntity.setStudentId(studentId);
        scoreEntity.setSubjectId(subjectId);
        scoreRepository.delete(scoreEntity);

        return commonRes;
    }

    public CommonRes findScores() {

        CommonRes commonRes = new CommonRes();

        List<ScoreEntity> scoreEntityList = scoreRepository.findAll();

        Map<String, Object> map = new HashMap<>();
        map.put("scores", scoreEntityList);
        commonRes.setData(map);

        return commonRes;
    }

    public CommonRes findAverageScore(Long studentId) {

        CommonRes commonRes = new CommonRes();

        existsByStudentId(studentId);

        Long averageScore = -1L;
        List<SubjectScore> mapList = scoreRepository.findSubjectScoreByStudentId(studentId);
        if (mapList != null && mapList.size() > 0)
            averageScore = scoreRepository.averageScoreByStudentId(studentId);

        Map<String, Object> map = new HashMap<>();
        map.put("averageScore", averageScore);
        map.put("subjects", mapList);
        commonRes.setData(map);

        return commonRes;
    }


    private void existsByStudentId(Long studentId) {
        if (studentId != null && !studentRepository.existsById(studentId))
            throw new BusinessException(ErrorCode.STUDENT_NOT_FOUND, studentId.toString());
    }

}
