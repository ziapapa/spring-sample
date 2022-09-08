package com.ziapapa.spring.sample.controller;

import com.ziapapa.spring.sample.dto.StudentSaveReq;
import com.ziapapa.spring.sample.dto.ScoreSaveReq;
import com.ziapapa.spring.sample.dto.common.CommonRes;
import com.ziapapa.spring.sample.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Slf4j
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<CommonRes> saveStudent(@RequestBody @Valid StudentSaveReq studentSaveReq) {
        return new ResponseEntity<>(studentService.saveStudent(studentSaveReq), HttpStatus.CREATED);
    }

    @GetMapping("/students")
    public ResponseEntity<CommonRes> findStudents() {
        return new ResponseEntity<>(studentService.findStudents(), HttpStatus.OK);
    }


    @DeleteMapping("/students/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/students/{studentId}/subjects/{subjectId}/scores")
    public ResponseEntity<CommonRes> saveStudentSubjectScroe(
            @PathVariable("studentId") @NotNull Long studentId,
            @PathVariable("subjectId") @NotNull Long subjectId,
            @RequestBody @Valid ScoreSaveReq scoreSaveReq) {
        return new ResponseEntity<>(studentService.saveScore(studentId, subjectId, scoreSaveReq.getScore()), HttpStatus.CREATED);
    }

    @PutMapping("/students/{studentId}/subjects/{subjectId}/scores")
    public ResponseEntity<CommonRes> updateStudentSubjectScroe(
            @PathVariable("studentId") @NotNull Long studentId,
            @PathVariable("subjectId") @NotNull Long subjectId,
            @RequestBody @Valid ScoreSaveReq scoreSaveReq) {
        return new ResponseEntity<>(studentService.updateScore(studentId, subjectId, scoreSaveReq.getScore()), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/students/{studentId}/subjects/{subjectId}/scores")
    public ResponseEntity<CommonRes> deleteStudentSubjectScroe(
            @PathVariable("studentId") @NotNull Long studentId,
            @PathVariable("subjectId") @NotNull Long subjectId) {
        return new ResponseEntity<>(studentService.deleteScore(studentId, subjectId), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/students/scores")
    public ResponseEntity<CommonRes> findScore() {
        return new ResponseEntity<>(studentService.findScores(), HttpStatus.OK);
    }

    @GetMapping("/students/{studentId}/average-score")
    public ResponseEntity<CommonRes> findAverageScore(
            @PathVariable("studentId") @NotNull Long studentId) {
        return new ResponseEntity<>(studentService.findAverageScore(studentId), HttpStatus.OK);
    }

}
