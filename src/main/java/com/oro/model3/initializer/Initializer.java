package com.oro.model3.initializer;

import com.oro.model3.entity.*;
import com.oro.model3.repository.*;
import com.oro.model3.util.ConstantUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
public class Initializer implements CommandLineRunner {

    private final UserProfileRepository userProfileRepository;

    private final ConferenceRepository conferenceRepository;

    private final IdentifierRepository identifierRepository;

    private final AuditoriumRepository auditoriumRepository;

    private final SeatRepository seatRepository;

    private final SubjectRepository subjectRepository;

    private final List<UserProfile> userProfileList = new ArrayList<>();

    private final List<Identifier> identifierList = new ArrayList<>();

    private final List<Subject> subjectList = new ArrayList<>();

    private final List<Seat> seatList = new ArrayList<>();

    private final List<Auditorium> auditoriumList = new ArrayList<>();

    private final List<Conference> conferenceList = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {
        initializeAuditoriumList();
        initializeSeatList();
        initializeConferenceList();
        initializeUserProfile();
        initializeIdentifierList();
        initializeSubjectList();

        auditoriumRepository.saveAll(auditoriumList);
        seatRepository.saveAll(seatList);
        conferenceRepository.saveAll(conferenceList);
        userProfileRepository.saveAll(userProfileList);
        identifierRepository.saveAll(identifierList);
        subjectRepository.saveAll(subjectList);
    }

    private void initializeAuditoriumList() {
        auditoriumList.addAll(
                Arrays.asList(
                        Auditorium.builder().id(1L).name("Auditorium 1").capacity(100).build(),
                        Auditorium.builder().id(2L).name("Auditorium 2").capacity(100).build(),
                        Auditorium.builder().id(3L).name("Auditorium 3").capacity(100).build()
                )
        );
    }

    private void initializeSeatList() {
        seatList.addAll(
                Arrays.asList(
                        Seat.builder().id(1L).row(1).number(1).auditorium(auditoriumList.get(0)).build(),
                        Seat.builder().id(2L).row(2).number(2).auditorium(auditoriumList.get(1)).build(),
                        Seat.builder().id(3L).row(3).number(3).auditorium(auditoriumList.get(2)).build()
                )
        );
    }


    private void initializeConferenceList() {
        conferenceList.addAll(
                Arrays.asList(
                        Conference.builder().id(1L).auditorium(auditoriumList.get(0)).conferenceStart(LocalDateTime.now().minusMonths(2).minusHours(2)).conferenceEnd(LocalDateTime.now().minusMonths(2)).build(),
                        Conference.builder().id(2L).auditorium(auditoriumList.get(1)).conferenceStart(LocalDateTime.now().plusMonths(2)).conferenceEnd(LocalDateTime.now().plusMonths(2).plusHours(2)).build(),
                        Conference.builder().id(3L).auditorium(auditoriumList.get(2)).conferenceStart(LocalDateTime.now()).conferenceEnd(LocalDateTime.now().plusHours(2)).build()
                )
        );
    }

    private void initializeUserProfile() {
        userProfileList.addAll(
                Arrays.asList(
                        UserProfile.builder().id(1L).email("email1@gmail.com").password("password1").firstname("Firstname1").lastname("Lastname1").age(18).country("Poland").city("Łódź").street("Marii Skłodowskiej-Curie 8/2").postalCode("09-879").build(),
                        UserProfile.builder().id(2L).email("email2@gmail.com").password("password2").firstname("Firstname2").lastname("Lastname2").age(19).country("Spain").city("Madrid").street("Calle Fuencarral 2/23").postalCode("91-092").build(),
                        UserProfile.builder().id(3L).email("email3@gmail.com").password("password3").firstname("Firstname3").lastname("Lastname3").age(20).country("England").city("London").street("Piccadilly Circus 5/34").postalCode("01-012").build()
                )
        );

    }

    private void initializeSubjectList() {
        subjectList.addAll(
                Arrays.asList(
                        Subject.builder().id(1L).title("title1").description("description1").conference(conferenceList.get(0)).presenter(userProfileList.get(0)).build(),
                        Subject.builder().id(2L).title("title2").description("description2").conference(conferenceList.get(1)).presenter(userProfileList.get(1)).build(),
                        Subject.builder().id(3L).title("title3").description("description3").conference(conferenceList.get(2)).presenter(userProfileList.get(2)).build(),
                        Subject.builder().id(4L).title("title4").description("description4").conference(conferenceList.get(0)).presenter(userProfileList.get(0)).build()
                )
        );
    }

    private void initializeIdentifierList() {
        identifierList.addAll(
                Arrays.asList(
                        Identifier.builder().id(1L).userProfile(userProfileList.get(0)).conference(conferenceList.get(0)).role(ConstantUtil.STUDENT).build(),
                        Identifier.builder().id(2L).userProfile(userProfileList.get(1)).conference(conferenceList.get(1)).role(ConstantUtil.HOST).build(),
                        Identifier.builder().id(3L).userProfile(userProfileList.get(2)).conference(conferenceList.get(2)).role(ConstantUtil.SCIENTIST).build()
                )
        );
    }
}
