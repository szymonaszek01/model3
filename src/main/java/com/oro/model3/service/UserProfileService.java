package com.oro.model3.service;

import com.oro.model3.entity.Identifier;
import com.oro.model3.entity.UserProfile;
import com.oro.model3.repository.IdentifierRepository;
import com.oro.model3.repository.SubjectRepository;
import com.oro.model3.repository.UserProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    private final IdentifierRepository identifierRepository;

    private final SubjectRepository subjectRepository;

    public List<UserProfile> getUserProfilesByConferenceId(long id) {
        return identifierRepository
                .findAllByConferenceId(id)
                .stream()
                .map(Identifier::getUserProfile)
                .collect(Collectors.toList());
    }

    public List<UserProfile> getUserProfilesByConferenceIdAndRole(long id, String role) {
        return identifierRepository
                .findAllByConferenceId(id)
                .stream()
                .filter(identifier -> identifier.getRole().equals(role))
                .map(Identifier::getUserProfile)
                .collect(Collectors.toList());
    }

    public List<UserProfile> getUserProfilesByConferenceIdAndCountry(long id, String country) {
        return identifierRepository
                .findAllByConferenceId(id)
                .stream()
                .map(Identifier::getUserProfile)
                .filter(userProfile -> userProfile.getCountry().equals(country))
                .collect(Collectors.toList());
    }

    public Optional<UserProfile> getUserProfileWithMaxSubjectList() {
        return userProfileRepository
                .findAll()
                .stream()
                .collect(Collectors.toMap(userProfile -> userProfile, userProfile -> subjectRepository.countByPresenterId(userProfile.getId())))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
}
