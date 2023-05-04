package com.oro.model3.controller;

import com.oro.model3.entity.Auditorium;
import com.oro.model3.entity.Conference;
import com.oro.model3.service.ConferenceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ConferenceController.class)
class ConferenceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConferenceService conferenceService;

    private static final String url = "/api/v1/conference";

    @Test
    void countAllByAuditoriumId() throws Exception {
        List<Auditorium> auditoriumList = Arrays.asList(
                Auditorium.builder().id(1L).name("Auditorium 1").capacity(100).build(),
                Auditorium.builder().id(2L).name("Auditorium 2").capacity(100).build()
        );

        List<Conference> conferenceList = Arrays.asList(
                Conference.builder().id(1L).auditorium(auditoriumList.get(0)).conferenceStart(LocalDateTime.now().minusMonths(2).minusHours(2)).conferenceEnd(LocalDateTime.now().minusMonths(2)).build(),
                Conference.builder().id(2L).auditorium(auditoriumList.get(1)).conferenceStart(LocalDateTime.now().plusMonths(2)).conferenceEnd(LocalDateTime.now().plusMonths(2).plusHours(2)).build()
        );

        when(conferenceService.countAllByAuditoriumId(1)).thenReturn(1L);
        mockMvc.perform(get(url + "/auditorium/id/{id}", 1L)).andDo(print()).andExpect(status().isOk());
    }
}
