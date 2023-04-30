package com.oro.model3.repository;

import com.oro.model3.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    List<Subject> findAllByConferenceId(long id);

    long countByPresenterId(long id);
}
