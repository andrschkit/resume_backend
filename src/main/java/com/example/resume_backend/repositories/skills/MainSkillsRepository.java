package com.example.resume_backend.repositories.skills;

import com.example.resume_backend.entities.skills.MainSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MainSkillsRepository extends JpaRepository<MainSkill, Long> {
    ArrayList<MainSkill> findAllByOrderByIdAsc();
}
