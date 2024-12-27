package ru.mtuci.volovodovskiy.service;

import ru.mtuci.volovodovskiy.model.LicenseType;
import ru.mtuci.volovodovskiy.request.DataLicenseTypeRequest;

import java.util.List;
import java.util.Optional;

public interface LicenseTypeService {
    Optional<LicenseType> getLicenseTypeById(Long id);

    // save
    LicenseType save(DataLicenseTypeRequest request);

    // read
    List<LicenseType> getAll();

    // update
    LicenseType update(DataLicenseTypeRequest request);

    // delete
    void delete(Long id);
}
