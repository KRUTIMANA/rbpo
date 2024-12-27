package ru.mtuci.volovodovskiy.controller;

import ru.mtuci.volovodovskiy.model.ApplicationUser;
import ru.mtuci.volovodovskiy.request.RegistrationRequest;
import ru.mtuci.volovodovskiy.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserServiceImpl userDetailsService;

    @PostMapping
    public ResponseEntity<?> registration(@RequestBody RegistrationRequest registrationRequest) {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setLogin(registrationRequest.getLogin());
        applicationUser.setEmail(registrationRequest.getEmail());

        if (!userDetailsService.saveUser(applicationUser, registrationRequest.getPassword()))
            return ResponseEntity.badRequest().body("Пользователь уже существует!");

        return ResponseEntity.ok("Регистрация прошла успешно!");
    }
}
