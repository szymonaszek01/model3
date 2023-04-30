package com.oro.model3.repository;

import com.oro.model3.entity.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {

    long countAllByAuditoriumId(long id);
}
