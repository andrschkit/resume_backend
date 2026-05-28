package com.example.resume_backend.rest.controller.skills;

import com.example.resume_backend.entities.skills.BackendSkill;
import com.example.resume_backend.services.skills.BackendSkillsService;
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
@Tag(name = "Контроллер backend навыков", description = "Взаимодейтсивие с backend навыками")
public class BackendSkillsRestController {

    private final BackendSkillsService backendSkillsService;

    public BackendSkillsRestController(BackendSkillsService backendSkillsService) {
        this.backendSkillsService = backendSkillsService;
    }

    @Operation(
            summary = "Получить backend навык по ID",
            description = "Позволяет получить конкретный backend навык по ID",
            security = @SecurityRequirement(name = "apiKeyAuth")
    )
    @GetMapping(URL_BACKEND_SKILL_ID)
    public BackendSkill getBackendSkillById(
            @PathVariable @Parameter(description = "Идентификатор backend навыка", required = true) Long id) {
        return backendSkillsService.findBackendSkillsById(id);
    }

    @Operation(
            summary = "Получить все backend навыки",
            description = "Позволяет получить все backend навыки из БД",
            security = @SecurityRequirement(name = "apiKeyAuth")
    )
    @GetMapping(URL_BACKEND_SKILLS)
    public ArrayList<BackendSkill> getAllBackendSkills() {
        return backendSkillsService.findAllBackendSkills();
    }
}
