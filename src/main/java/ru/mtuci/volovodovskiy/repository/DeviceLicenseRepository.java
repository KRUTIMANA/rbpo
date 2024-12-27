package ru.mtuci.volovodovskiy.repository;

import ru.mtuci.volovodovskiy.model.Device;
import ru.mtuci.volovodovskiy.model.DeviceLicense;
import ru.mtuci.volovodovskiy.model.License;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceLicenseRepository extends JpaRepository<DeviceLicense, Long> {
    Optional<DeviceLicense> findByDeviceAndLicense(Device device, License license);
}
