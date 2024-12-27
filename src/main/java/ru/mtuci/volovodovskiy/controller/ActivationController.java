package ru.mtuci.volovodovskiy.controller;

import ru.mtuci.volovodovskiy.configuration.JwtTokenProvider;
import ru.mtuci.volovodovskiy.exceptions.categories.UserNotFoundException;
import ru.mtuci.volovodovskiy.model.ApplicationUser;
import ru.mtuci.volovodovskiy.model.Device;
import ru.mtuci.volovodovskiy.model.Ticket;
import ru.mtuci.volovodovskiy.request.DeviceRequest;
import ru.mtuci.volovodovskiy.service.impl.DeviceServiceImpl;
import ru.mtuci.volovodovskiy.service.impl.LicenseServiceImpl;
import ru.mtuci.volovodovskiy.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activation")
@RequiredArgsConstructor
public class ActivationController {
    private final UserServiceImpl userService;
    private final DeviceServiceImpl deviceService;
    private final JwtTokenProvider jwtTokenProvider;
    private final LicenseServiceImpl licenseService;

    @PostMapping
    public ResponseEntity<?> activateLicense(@RequestHeader("Authorization") String auth, @RequestBody DeviceRequest deviceRequest) {
        try {
            // Получить аутентифицированного пользователя
            String login = jwtTokenProvider.getUsername(auth.split(" ")[1]);
            ApplicationUser user = userService.getUserByLogin(login).orElseThrow(
                    () -> new UserNotFoundException("Пользователь не найден")
            );

            // Получить устройство
            Device device = deviceService.registerOrUpdateDevice(deviceRequest.getName(), deviceRequest.getMacAddress(), user);

            Ticket ticket = licenseService.activateLicense(deviceRequest.getActivationCode(), device, user);

            return ResponseEntity.ok(ticket);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(String.format("Ошибка(%s)", e.getMessage()));
        }
    }
}
