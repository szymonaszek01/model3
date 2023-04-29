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
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Identifier identifier;

    @Column(unique = true)
    private String title;

    @Column(unique = true)
    private String description;

    @ManyToOne
    private Conference conference;
}
