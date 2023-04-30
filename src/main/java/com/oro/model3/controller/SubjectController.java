package com.oro.model3.controller;

import com.oro.model3.entity.Subject;
import com.oro.model3.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/subject")
@RestController
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/conference/id/{id}")
    public List<Subject> getSubjectsByConferenceId(@PathVariable long id) {
        return subjectService.getSubjectsByConferenceId(id);
    }
}
