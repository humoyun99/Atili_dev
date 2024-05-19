package com.example.atili.entity;

import com.example.atili.enums.ProfileRole;
import com.example.atili.enums.ProfileStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "profile")
@Getter
@Setter
public class ProfileEntity {
    @SequenceGenerator(
            name = "profile_sequence",
            sequenceName = "profile_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "profile_sequence" )
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column(unique = true)
    private String email;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    @Column
    private ProfileStatus status;
    @Enumerated(EnumType.STRING)
    @Column
    private ProfileRole role;
    @CreationTimestamp
    @Column
    private LocalDateTime createdDate;
    @Column
    private Boolean visible  = Boolean.TRUE;
}
