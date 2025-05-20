package com.example.resume_backend.repositories.skills;

import com.example.resume_backend.entities.skills.FrontendSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface FrontendSkillsRepository extends JpaRepository<FrontendSkills, Long> {
    Optional<ArrayList<FrontendSkills>> findAllByOrderByIdDesc();
}
