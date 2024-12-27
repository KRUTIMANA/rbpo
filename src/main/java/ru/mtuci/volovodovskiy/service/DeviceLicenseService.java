package ru.mtuci.volovodovskiy.service;

import ru.mtuci.volovodovskiy.model.DeviceLicense;
import ru.mtuci.volovodovskiy.request.DataDeviceLicenseRequest;

import java.util.List;

public interface DeviceLicenseService {
    DeviceLicense saveDeviceLicense(DeviceLicense deviceLicense);

    // save
    DeviceLicense save(DataDeviceLicenseRequest request);

    // read
    List<DeviceLicense> getAll();

    // update
    DeviceLicense update(DataDeviceLicenseRequest request);

    // delete
    void delete(Long id);
}
