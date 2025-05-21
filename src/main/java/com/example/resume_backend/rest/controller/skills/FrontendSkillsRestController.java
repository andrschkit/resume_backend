package com.example.resume_backend.rest.controller.skills;

import com.example.resume_backend.entities.skills.FrontendSkill;
import com.example.resume_backend.services.skills.FrontendSkillsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static com.example.resume_backend.utils.Endpoints.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Контроллер frontend навыков", description = "Взаимодейтсивие с frontend навыками")
public class FrontendSkillsRestController {

    private final FrontendSkillsService frontendSkillsService;

    public FrontendSkillsRestController(FrontendSkillsService frontendSkillsService) {
        this.frontendSkillsService = frontendSkillsService;
    }

    @Operation(
            summary = "Получить frontend навык по ID",
            description = "Позволяет получить конкретный frontend навык по ID",
            security = @SecurityRequirement(name = "apiKeyAuth")
    )
    @GetMapping(URL_FRONTEND_SKILL_ID)
    public FrontendSkill getFrontendSkillById(
            @PathVariable @Parameter(description = "Идентификатор frontend навыка", required = true) Long id) {
        return frontendSkillsService.findFrontendSkillsById(id);
    }

    @Operation(
            summary = "Получить все frontend навыки",
            description = "Позволяет получить все frontend навыки из БД",
            security = @SecurityRequirement(name = "apiKeyAuth")
    )
    @GetMapping(URL_FRONTEND_SKILLS)
    public ArrayList<FrontendSkill> getAllFrontendSkills() {
        return frontendSkillsService.findAllFrontendSkills();
    }
}
