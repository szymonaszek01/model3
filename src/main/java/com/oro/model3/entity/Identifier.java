package com.oro.model3.entity;

import jakarta.persistence.*;
import lombok.*;

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
}
