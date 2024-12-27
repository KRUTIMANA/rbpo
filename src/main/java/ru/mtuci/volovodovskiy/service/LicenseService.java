package ru.mtuci.volovodovskiy.service;

import ru.mtuci.volovodovskiy.model.ApplicationUser;
import ru.mtuci.volovodovskiy.model.Device;
import ru.mtuci.volovodovskiy.model.License;
import ru.mtuci.volovodovskiy.model.Ticket;
import ru.mtuci.volovodovskiy.request.DataLicenseRequest;

import java.util.List;

public interface LicenseService {
    License createLicense(
            Long productId, Long ownerId, Long licenseTypeId,
            Integer device_count, Long duration
            );

    Ticket activateLicense(String activationCode, Device device, ApplicationUser user);
    Ticket generateTicket(License license, Device device, String description);
    List<Ticket> licenseRenewal(String activationCode, ApplicationUser user, String durationAdd);

    boolean validateLicense(License license, Device device, ApplicationUser user);
    void createDeviceLicense(License license, Device device);
    void updateLicense(License license);

    License getActiveLicensesForDevice(Device device, ApplicationUser user, String activationCode);

    // save
    License save(DataLicenseRequest request);

    // read
    List<License> getAll();

    // update
    License update(DataLicenseRequest request);

    // delete
    void delete(Long id);
}
