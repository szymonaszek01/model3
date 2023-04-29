package com.oro.model3.repository;

import com.oro.model3.entity.Conference;
import com.oro.model3.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {

}
