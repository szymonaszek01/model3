package com.oro.model3.controller;

import com.oro.model3.entity.UserProfile;
import com.oro.model3.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/user-profile")
@RestController
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping("/conference/id/{id}")
    public List<UserProfile> getUserProfilesByConferenceId(@PathVariable long id) {
        return userProfileService.getUserProfilesByConferenceId(id);
    }

    @GetMapping("/conference/id/{id}/role/{role}")
    public List<UserProfile> getUserProfilesByConferenceIdAndRole(@PathVariable long id, @PathVariable String role) {
        return userProfileService.getUserProfilesByConferenceIdAndRole(id, role);
    }

    @GetMapping("/conference/id/{id}/country/{country}")
    public List<UserProfile> getUserProfilesByConferenceIdAndCountry(@PathVariable long id, @PathVariable String country) {
        return userProfileService.getUserProfilesByConferenceIdAndCountry(id, country);
    }

    @GetMapping("subject/max")
    public ResponseEntity<UserProfile> getUserProfileWithMaxSubjectList() {
        Optional<UserProfile> result = userProfileService.getUserProfileWithMaxSubjectList();
        if (result.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(result.get());
    }
}
