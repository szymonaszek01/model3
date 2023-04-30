package com.oro.model3.controller;

import com.oro.model3.service.ConferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/conference")
@RestController
@RequiredArgsConstructor
public class ConferenceController {

    private final ConferenceService conferenceService;

    @GetMapping("/auditorium/id/{id}")
    public long countAllByAuditoriumId(@PathVariable long id) {
        return conferenceService.countAllByAuditoriumId(id);
    }
}
