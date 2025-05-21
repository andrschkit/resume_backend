package com.example.resume_backend.rest.controller;

import com.example.resume_backend.entities.EducationPlace;
import com.example.resume_backend.services.EducationPlaceService;
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
@Tag(name = "Контроллер мест образования", description = "Взаимодейтсивие с местами образования")
public class EducationPlaceRestController {

    private final EducationPlaceService educationPlaceService;

    public EducationPlaceRestController(EducationPlaceService educationPlaceService) {
        this.educationPlaceService = educationPlaceService;
    }

    @Operation(
            summary = "Получить место образования по ID",
            description = "Позволяет получить место образования по ID",
            security = @SecurityRequirement(name = "apiKeyAuth")
    )
    @GetMapping(URL_EDUCATION_PLACE_ID)
    public EducationPlace getEducationPlaceById(
            @PathVariable @Parameter(description = "Идентификатор места образования", required = true) Long id) {
        return educationPlaceService.findEducationPlaceById(id);
    }

    @Operation(
            summary = "Получить все места образования",
            description = "Позволяет получить все места образования из БД",
            security = @SecurityRequirement(name = "apiKeyAuth")
    )
    @GetMapping(URL_EDUCATION_PLACES)
    public ArrayList<EducationPlace> getAllEducationPlaces() {
        return educationPlaceService.findAllEducationPlaces();
    }
}
