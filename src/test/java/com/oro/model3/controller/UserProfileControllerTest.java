package com.oro.model3.controller;

import com.oro.model3.entity.UserProfile;
import com.oro.model3.service.UserProfileService;
import com.oro.model3.util.ConstantUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserProfileController.class)
class UserProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserProfileService userProfileService;

    private static final String url = "/api/v1/user-profile";

    @Test
    void getUserProfilesByConferenceIdShouldReturnStatus200() throws Exception {
        List<UserProfile> userProfileList = Arrays.asList(
                UserProfile.builder().id(1L).email("email1@gmail.com").password("password1").firstname("Firstname1").lastname("Lastname1").age(18).country("Poland").city("Łódź").street("Marii Skłodowskiej-Curie 8/2").postalCode("09-879").build(),
                UserProfile.builder().id(2L).email("email2@gmail.com").password("password2").firstname("Firstname2").lastname("Lastname2").age(19).country("Spain").city("Madrid").street("Calle Fuencarral 2/23").postalCode("91-092").build()
        );

        when(userProfileService.getUserProfilesByConferenceId(2)).thenReturn(userProfileList);
        mockMvc.perform(get(url + "/conference/id/{id}", 2L)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getUserProfilesByConferenceIdAndRole() throws Exception {
        List<UserProfile> userProfileList = Arrays.asList(
                UserProfile.builder().id(1L).email("email1@gmail.com").password("password1").firstname("Firstname1").lastname("Lastname1").age(18).country("Poland").city("Łódź").street("Marii Skłodowskiej-Curie 8/2").postalCode("09-879").build(),
                UserProfile.builder().id(2L).email("email2@gmail.com").password("password2").firstname("Firstname2").lastname("Lastname2").age(19).country("Spain").city("Madrid").street("Calle Fuencarral 2/23").postalCode("91-092").build()
        );

        when(userProfileService.getUserProfilesByConferenceIdAndRole(2, ConstantUtil.STUDENT)).thenReturn(userProfileList);
        mockMvc.perform(get(url + "/conference/id/{id}/role/{role}", 2L, ConstantUtil.STUDENT)).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getUserProfilesByConferenceIdAndCountry() throws Exception {
        List<UserProfile> userProfileList = Arrays.asList(
                UserProfile.builder().id(1L).email("email1@gmail.com").password("password1").firstname("Firstname1").lastname("Lastname1").age(18).country("Spain").city("Łódź").street("Marii Skłodowskiej-Curie 8/2").postalCode("09-879").build(),
                UserProfile.builder().id(2L).email("email2@gmail.com").password("password2").firstname("Firstname2").lastname("Lastname2").age(19).country("Spain").city("Madrid").street("Calle Fuencarral 2/23").postalCode("91-092").build()
        );

        when(userProfileService.getUserProfilesByConferenceIdAndCountry(2, "Spain")).thenReturn(userProfileList);
        mockMvc.perform(get(url + "/conference/id/{id}/country/{country}", 2L, "Spain")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getUserProfileWithMaxSubjectList() throws Exception {
        UserProfile userProfile = UserProfile.builder().id(2L).email("email2@gmail.com").password("password2").firstname("Firstname2").lastname("Lastname2").age(19).country("Spain").city("Madrid").street("Calle Fuencarral 2/23").postalCode("91-092").build();

        when(userProfileService.getUserProfileWithMaxSubjectList()).thenReturn(Optional.of(userProfile));
        mockMvc.perform(get(url + "/subject/max")).andDo(print()).andExpect(status().isOk());
    }
}
