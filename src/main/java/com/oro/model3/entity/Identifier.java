package com.oro.model3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Identifier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String role;

    @ManyToOne
    private Conference conference;

    @ManyToOne
    private UserProfile userProfile;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "identifier", cascade = CascadeType.ALL)
    private List<Subject> subjectList;
}
