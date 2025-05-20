package com.example.resume_backend.repositories.skills;

import com.example.resume_backend.entities.skills.MainSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface MainSkillsRepository extends JpaRepository<MainSkills, Long> {
    Optional<ArrayList<MainSkills>> findAllByOrderByIdDesc();
}
