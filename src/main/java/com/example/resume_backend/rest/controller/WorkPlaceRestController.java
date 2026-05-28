package com.example.resume_backend.rest.controller;

import com.example.resume_backend.entities.WorkPlace;
import com.example.resume_backend.services.WorkPlaceService;
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
@Tag(name = "Контроллер мест работы", description = "Взаимодейтсивие с местами работы")
public class WorkPlaceRestController {

    private final WorkPlaceService workPlaceService;

    public WorkPlaceRestController(WorkPlaceService workPlaceService) {
        this.workPlaceService = workPlaceService;
    }

    @Operation(
            summary = "Получить место работы по ID",
            description = "Позволяет получить конкретное место работы по ID",
            security = @SecurityRequirement(name = "apiKeyAuth")
    )
    @GetMapping(URL_WORK_PLACE_ID)
    public WorkPlace getWorkPlaceById(
            @PathVariable @Parameter(description = "Идентификатор места работы", required = true) Long id) {
        return workPlaceService.findWorkPlaceById(id);
    }

    @Operation(
            summary = "Получить все места работы",
            description = "Позволяет получить все места работы из БД",
            security = @SecurityRequirement(name = "apiKeyAuth")
    )
    @GetMapping(URL_WORK_PLACES)
    public ArrayList<WorkPlace> getAllWorkPlaces() {
        return workPlaceService.findAllWorkPlaces();
    }
}
