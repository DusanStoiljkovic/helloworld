package com.singidunum.helloworld.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "recruiter_profile")
public class RecruiterProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userAccountId;

    @OneToOne
    @JoinColumn(name = "user_account_id")
    @MapsId
    private Users userId;

    private String firstName;
    private String lastName;
    private String city;
    private String country;
    private String company;
    @Column(nullable = true, length = 64)
    private String profilePhoto;

    public RecruiterProfile(Users user) {
        this.userId = user;
    }

    public RecruiterProfile() {

    }
}
