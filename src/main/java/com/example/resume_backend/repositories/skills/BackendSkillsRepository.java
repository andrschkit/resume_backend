package com.example.resume_backend.repositories.skills;

import com.example.resume_backend.entities.skills.BackendSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BackendSkillsRepository extends JpaRepository<BackendSkill, Long> {
    ArrayList<BackendSkill> findAllByOrderByIdAsc();
}
