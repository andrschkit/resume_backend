package com.example.resume_backend.repositories.skills;

import com.example.resume_backend.entities.skills.FrontendSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface FrontendSkillsRepository extends JpaRepository<FrontendSkill, Long> {
    ArrayList<FrontendSkill> findAllByOrderByIdAsc();
}
