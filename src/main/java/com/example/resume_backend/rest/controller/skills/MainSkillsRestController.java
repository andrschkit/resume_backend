package com.example.resume_backend.rest.controller.skills;

import com.example.resume_backend.entities.EducationPlace;
import com.example.resume_backend.entities.skills.MainSkill;
import com.example.resume_backend.services.skills.MainSkillsService;
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
@Tag(name = "Контроллер основных навыков", description = "Взаимодейтсивие с основными навыками")
public class MainSkillsRestController {

    private final MainSkillsService mainSkillsService;

    public MainSkillsRestController(MainSkillsService mainSkillsService) {
        this.mainSkillsService = mainSkillsService;
    }

    @Operation(
            summary = "Получить основной навык по ID",
            description = "Позволяет получить конкретный основной навык по ID",
            security = @SecurityRequirement(name = "apiKeyAuth")
    )
    @GetMapping(URL_MAIN_SKILL_ID)
    public MainSkill getMainSkillById(
            @PathVariable @Parameter(description = "Идентификатор основного навыка", required = true) Long id) {
        return mainSkillsService.findMainSkillById(id);
    }

    @Operation(
            summary = "Получить все основные навыки",
            description = "Позволяет получить все основные навыки из БД",
            security = @SecurityRequirement(name = "apiKeyAuth")
    )
    @GetMapping(URL_MAIN_SKILLS)
    public ArrayList<MainSkill> getAllMainSkills() {
        return mainSkillsService.findAllMainSkills();
    }
}
