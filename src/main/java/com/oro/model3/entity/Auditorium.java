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
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int capacity;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "auditorium", cascade = CascadeType.ALL)
    private List<Conference> conferenceList;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "auditorium", cascade = CascadeType.ALL)
    private List<Seat> seatList;
}
