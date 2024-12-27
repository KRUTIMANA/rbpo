package ru.mtuci.volovodovskiy.controller;

import ru.mtuci.volovodovskiy.configuration.JwtTokenProvider;
import ru.mtuci.volovodovskiy.exceptions.categories.DeviceNotFoundException;
import ru.mtuci.volovodovskiy.exceptions.categories.UserNotFoundException;
import ru.mtuci.volovodovskiy.exceptions.categories.License.LicenseNotFoundException;
import ru.mtuci.volovodovskiy.model.ApplicationUser;
import ru.mtuci.volovodovskiy.model.Device;
import ru.mtuci.volovodovskiy.model.License;
import ru.mtuci.volovodovskiy.model.Ticket;
import ru.mtuci.volovodovskiy.request.DeviceInfoRequest;
import ru.mtuci.volovodovskiy.service.impl.DeviceServiceImpl;
import ru.mtuci.volovodovskiy.service.impl.LicenseServiceImpl;
import ru.mtuci.volovodovskiy.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licenseInfo")
@RequiredArgsConstructor
public class LicenseInfoController {
    private final UserServiceImpl userService;
    private final DeviceServiceImpl deviceService;
    private final JwtTokenProvider jwtTokenProvider;
    private final LicenseServiceImpl licenseService;

    @PostMapping
    public ResponseEntity<?> getLicenseInfo(@RequestHeader("Authorization") String auth, @RequestBody DeviceInfoRequest deviceInfoRequest) {
        try {
            String login = jwtTokenProvider.getUsername(auth.split(" ")[1]);
            ApplicationUser user = userService.getUserByLogin(login).orElseThrow(
                    () -> new UserNotFoundException("Пользователь не найден")
            );

            Device device = deviceService.findDeviceByInfo(deviceInfoRequest.getName(), deviceInfoRequest.getMacAddress(), user).orElseThrow(
                    () -> new DeviceNotFoundException("Устройство не найдено")
            );

            License userLicense = licenseService.getActiveLicensesForDevice(device,user,deviceInfoRequest.getActivationCode());
            
            Ticket ticket = licenseService.generateTicket(userLicense, device, "Информация о лицензии");
            
            return ResponseEntity.ok(ticket);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(String.format("Ошибка(%s)", e.getMessage()));
        }
    }
}
