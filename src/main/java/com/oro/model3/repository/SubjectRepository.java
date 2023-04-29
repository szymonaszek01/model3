package com.oro.model3.repository;

import com.oro.model3.entity.Seat;
import com.oro.model3.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
