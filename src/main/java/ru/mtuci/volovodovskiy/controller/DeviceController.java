package ru.mtuci.volovodovskiy.controller;

import ru.mtuci.volovodovskiy.model.Device;
import ru.mtuci.volovodovskiy.request.DataDeviceRequest;
import ru.mtuci.volovodovskiy.service.impl.DeviceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage/device")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class DeviceController {
    private final DeviceServiceImpl deviceService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody DataDeviceRequest deviceRequest) {
        try {
            Device device = deviceService.save(deviceRequest);
            deviceRequest.setId(device.getId());
            return ResponseEntity.ok(deviceRequest);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<Device> devices = deviceService.getAll();
            List<DataDeviceRequest> dataDevices = devices.stream().map(
                    device -> new DataDeviceRequest(
                            device.getId(),
                            device.getUser().getId(),
                            device.getName(),
                            device.getMacAddress()
                    )
            ).toList();
            return ResponseEntity.ok(dataDevices);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody DataDeviceRequest deviceRequest) {
        try {
            deviceService.update(deviceRequest);
            return ResponseEntity.ok(deviceRequest);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long id) {
        try {
            deviceService.delete(id);
            return ResponseEntity.ok("Устройство удалено");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
