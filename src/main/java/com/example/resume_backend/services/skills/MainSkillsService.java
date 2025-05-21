package com.example.resume_backend.services.skills;

import com.example.resume_backend.entities.skills.MainSkill;
import com.example.resume_backend.exceptions.NotFoundException;
import com.example.resume_backend.repositories.skills.MainSkillsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.example.resume_backend.utils.StaticStrings.NOT_FOUND_EXCEPTION_MAIN_SKILLS;

@Service
public class MainSkillsService {

    private final MainSkillsRepository mainSkillsRepository;

    public MainSkillsService(MainSkillsRepository mainSkillsRepository) { this.mainSkillsRepository = mainSkillsRepository; }

    public MainSkill findMainSkillById(Long id) {return mainSkillsRepository.findById(id)
            .orElseThrow(()-> new NotFoundException(NOT_FOUND_EXCEPTION_MAIN_SKILLS, id.toString()));}

    public ArrayList<MainSkill> findAllMainSkills() {return mainSkillsRepository.findAllByOrderByIdAsc();}
}
