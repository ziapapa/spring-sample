package com.ziapapa.spring.sample.controller;

import com.ziapapa.spring.sample.dto.SubjectSaveReq;
import com.ziapapa.spring.sample.dto.common.CommonRes;
import com.ziapapa.spring.sample.service.SubjectService;
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
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("/subjects")
    public ResponseEntity<CommonRes> savedSubjects(@RequestBody @Valid SubjectSaveReq subjectSaveReq) {
        return new ResponseEntity<>(subjectService.saveSubject(subjectSaveReq), HttpStatus.CREATED);
    }

    @GetMapping("/subjects")
    public ResponseEntity<CommonRes> findSubjects() {
        return new ResponseEntity<>(subjectService.findSubjects(), HttpStatus.OK);
    }

    @DeleteMapping("/subjects/{subjectId}")
    public ResponseEntity deleteSubject(@PathVariable("subjectId") @NotNull Long id ) {
        subjectService.deleteSubject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/subjects/{subjectId}/average-score")
    public ResponseEntity<CommonRes> findScore(
            @PathVariable("subjectId") @NotNull Long subjectId) {
        return new ResponseEntity<>(subjectService.findSubjects(), HttpStatus.OK);
    }
}
