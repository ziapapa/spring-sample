package com.ziapapa.spring.sample.service;

import com.ziapapa.spring.sample.dto.common.CommonRes;
import com.ziapapa.spring.sample.entity.SubjectEntity;
import com.ziapapa.spring.sample.exception.BusinessException;
import com.ziapapa.spring.sample.exception.ErrorCode;
import com.ziapapa.spring.sample.repository.ScoreRepository;
import com.ziapapa.spring.sample.repository.SubjectRepository;
import com.ziapapa.spring.sample.repository.dto.StudentScore;
import com.ziapapa.spring.sample.dto.SubjectSaveReq;
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
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final ScoreRepository scoreRepository;

    public CommonRes saveSubject(SubjectSaveReq subjectSaveReq) {

        CommonRes commonRes = new CommonRes();

        String name = subjectSaveReq.getSubject().getName();
        if (subjectRepository.existsByName(name))
            throw new BusinessException(ErrorCode.ALREADY_EXIST_SUBJECT, name);

        SubjectEntity subjectEntity = new SubjectEntity();
        BeanUtils.copyProperties(subjectSaveReq.getSubject(), subjectEntity);
        subjectRepository.save(subjectEntity);

        return commonRes;
    }

    public CommonRes findSubjects() {

        CommonRes commonRes = new CommonRes();

        List<SubjectEntity> subjectEntityList = subjectRepository.findAll();

        Map<String, Object> map = new HashMap<>();
        map.put("students", subjectEntityList);
        commonRes.setData(map);

        return commonRes;
    }

    public void deleteSubject(Long id) {

        try {
            subjectRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            // either do nothing to return a 204, or throw new NotFoundException();
        }
        return;
    }

    public CommonRes findAverageScore(Long subjectId) {

        CommonRes commonRes = new CommonRes();

        existsBySubjectId(subjectId);

        Long averageScore = -1L;
        List<StudentScore> mapList = scoreRepository.findStudentScoreBySubjectId(subjectId);
        if (mapList != null && mapList.size() > 0)
            averageScore = scoreRepository.averageScoreBySubjectId(subjectId);

        Map<String, Object> map = new HashMap<>();
        map.put("averageScore", averageScore);
        map.put("students", mapList);
        commonRes.setData(map);

        return commonRes;
    }

    public void existsBySubjectId(Long subjectId) {
        if (subjectId != null && !subjectRepository.existsById(subjectId))
            throw new BusinessException(ErrorCode.SUBJECT_NOT_FOUND, subjectId.toString());
    }
}
