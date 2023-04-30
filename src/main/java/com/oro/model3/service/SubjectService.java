package com.oro.model3.service;

import com.oro.model3.entity.Subject;
import com.oro.model3.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public List<Subject> getSubjectsByConferenceId(long id) {
        return subjectRepository.findAllByConferenceId(id);
    }
}
