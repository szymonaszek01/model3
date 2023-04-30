package com.oro.model3.repository;

import com.oro.model3.entity.Identifier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IdentifierRepository extends JpaRepository<Identifier, Long> {

    List<Identifier> findAllByConferenceId(long id);
}
