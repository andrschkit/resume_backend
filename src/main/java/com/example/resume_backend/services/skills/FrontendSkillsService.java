package com.example.resume_backend.services.skills;

import com.example.resume_backend.entities.skills.FrontendSkill;
import com.example.resume_backend.exceptions.NotFoundException;
import com.example.resume_backend.repositories.skills.FrontendSkillsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.example.resume_backend.utils.StaticStrings.NOT_FOUND_EXCEPTION_FRONTEND_SKILLS;

@Service
public class FrontendSkillsService {

    private final FrontendSkillsRepository frontendSkillsRepository;

    public FrontendSkillsService(FrontendSkillsRepository frontendSkillsRepository) { this.frontendSkillsRepository = frontendSkillsRepository; }

    public FrontendSkill findFrontendSkillsById(Long id) {return frontendSkillsRepository.findById(id)
            .orElseThrow(()-> new NotFoundException(NOT_FOUND_EXCEPTION_FRONTEND_SKILLS, id.toString()));}

    public ArrayList<FrontendSkill> findAllFrontendSkills() {return frontendSkillsRepository.findAllByOrderByIdAsc();}
}
