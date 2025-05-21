package com.example.resume_backend.rest.controller;

import com.example.resume_backend.entities.User;
import com.example.resume_backend.entities.WorkPlace;
import com.example.resume_backend.services.UserService;
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
@Tag(name = "Контроллер пользователей", description = "Взаимодейтсивие с пользователями")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @Operation(
            summary = "Получить пользователя по ID",
            description = "Позволяет получить конкретного пользователя по ID",
            security = @SecurityRequirement(name = "apiKeyAuth")
    )
    @GetMapping(URL_USER_ID)
    public User getUsersById(
            @PathVariable @Parameter(description = "Идентификатор пользователя", required = true) Long id) {
        return userService.findUserById(id);
    }

    @Operation(
            summary = "Получить всех пользователей",
            description = "Позволяет получить всех пользователей из БД",
            security = @SecurityRequirement(name = "apiKeyAuth")
    )
    @GetMapping(URL_USERS)
    public ArrayList<User> getAllUsers() {
        return userService.findAllUsers();
    }
}
