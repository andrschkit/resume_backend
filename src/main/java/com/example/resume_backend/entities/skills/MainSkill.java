package com.example.resume_backend.entities.skills;

import jakarta.persistence.*;

@Entity
@Table(name = "main_skills", schema = "skills")
public class MainSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "main_skills_id")
    private Long id;

    @Column(name = "main_skills_name")
    private String name;

    @Column(name = "main_skills_description")
    private String description;

    @Column(name = "main_skills_logo")
    private String logo;

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
}
