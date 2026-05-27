package com.example.resume_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "education_place", schema = "education")
public class EducationPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_place_id")
    private Long id;

    @Column(name = "education_place_name")
    private String name;

    @Column(name = "education_place_description")
    private String description;

    @Column(name = "education_place_logo")
    private String logo;

    @Column(name = "education_place_time_interval")
    private String interval;

    @Column(name = "education_place_certificate_url")
    private String certificateUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getCertificateUrl() {
        return certificateUrl;
    }

    public void setCertificateUrl(String certificateUrl) {
        this.certificateUrl = certificateUrl;
    }
}
