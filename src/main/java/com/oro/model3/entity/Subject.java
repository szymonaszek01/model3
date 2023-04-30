package com.oro.model3.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private UserProfile presenter;

    @Column(unique = true)
    private String title;

    @Column(unique = true)
    private String description;

    @ManyToOne
    private Conference conference;
}
