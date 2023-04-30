package com.oro.model3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String firstname;

    private String lastname;

    private int age;

    private String country;

    private String city;

    private String street;

    private String postalCode;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userProfile", cascade = CascadeType.ALL)
    private List<Identifier> identifierList;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "presenter", cascade = CascadeType.ALL)
    private List<Subject> subjectList;
}
