package com.oro.model3.service;

import com.oro.model3.repository.ConferenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;

    public long countAllByAuditoriumId(long id) {
        return conferenceRepository.countAllByAuditoriumId(id);
    }
}
