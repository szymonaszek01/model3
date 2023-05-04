package com.oro.model3.controller;

import com.oro.model3.entity.Auditorium;
import com.oro.model3.entity.Conference;
import com.oro.model3.entity.Subject;
import com.oro.model3.entity.UserProfile;
import com.oro.model3.service.SubjectService;
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

@WebMvcTest(SubjectController.class)
class SubjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubjectService subjectService;

    private static final String url = "/api/v1/subject";

    @Test
    void getSubjectsByConferenceIdShouldReturnStatus200() throws Exception {
        List<Auditorium> auditoriumList = Arrays.asList(
                Auditorium.builder().id(1L).name("Auditorium 1").capacity(100).build(),
                Auditorium.builder().id(2L).name("Auditorium 2").capacity(100).build()
        );

        List<Conference> conferenceList = Arrays.asList(
                Conference.builder().id(1L).auditorium(auditoriumList.get(0)).conferenceStart(LocalDateTime.now().minusMonths(2).minusHours(2)).conferenceEnd(LocalDateTime.now().minusMonths(2)).build(),
                Conference.builder().id(2L).auditorium(auditoriumList.get(1)).conferenceStart(LocalDateTime.now().plusMonths(2)).conferenceEnd(LocalDateTime.now().plusMonths(2).plusHours(2)).build()
        );

        List<UserProfile> userProfileList = Arrays.asList(
                UserProfile.builder().id(1L).email("email1@gmail.com").password("password1").firstname("Firstname1").lastname("Lastname1").age(18).country("Poland").city("Łódź").street("Marii Skłodowskiej-Curie 8/2").postalCode("09-879").build(),
                UserProfile.builder().id(2L).email("email2@gmail.com").password("password2").firstname("Firstname2").lastname("Lastname2").age(19).country("Spain").city("Madrid").street("Calle Fuencarral 2/23").postalCode("91-092").build()
        );

        List<Subject> subjectList = Arrays.asList(
                Subject.builder().id(1L).title("title1").description("description1").conference(conferenceList.get(0)).presenter(userProfileList.get(0)).build(),
                Subject.builder().id(2L).title("title2").description("description2").conference(conferenceList.get(1)).presenter(userProfileList.get(1)).build()
        );

        when(subjectService.getSubjectsByConferenceId(2)).thenReturn(subjectList);
        mockMvc.perform(get(url + "/conference/id/{id}", 2L)).andDo(print()).andExpect(status().isOk());
    }
}
