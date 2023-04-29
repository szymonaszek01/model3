package com.oro.model3.repository;

import com.oro.model3.entity.Auditorium;
import com.oro.model3.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {

}
