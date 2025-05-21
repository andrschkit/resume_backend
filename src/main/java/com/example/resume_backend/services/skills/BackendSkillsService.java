package com.example.resume_backend.services.skills;

import com.example.resume_backend.entities.skills.BackendSkill;
import com.example.resume_backend.exceptions.NotFoundException;
import com.example.resume_backend.repositories.skills.BackendSkillsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.example.resume_backend.utils.StaticStrings.NOT_FOUND_EXCEPTION_BACKEND_SKILLS;

@Service
public class BackendSkillsService {

    private final BackendSkillsRepository backendSkillsRepository;

    public BackendSkillsService(BackendSkillsRepository backendSkillsRepository) { this.backendSkillsRepository = backendSkillsRepository; }

    public BackendSkill findBackendSkillsById(Long id) {return backendSkillsRepository.findById(id)
            .orElseThrow(()-> new NotFoundException(NOT_FOUND_EXCEPTION_BACKEND_SKILLS, id.toString()));}

    public ArrayList<BackendSkill> findAllBackendSkills() {return backendSkillsRepository.findAllByOrderByIdAsc();}
}
