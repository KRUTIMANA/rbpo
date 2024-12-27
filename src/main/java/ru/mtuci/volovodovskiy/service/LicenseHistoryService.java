package ru.mtuci.volovodovskiy.service;

import ru.mtuci.volovodovskiy.model.ApplicationUser;
import ru.mtuci.volovodovskiy.model.License;
import ru.mtuci.volovodovskiy.model.LicenseHistory;
import ru.mtuci.volovodovskiy.request.DataLicenseHistoryRequest;

import java.util.List;
import java.util.Optional;

public interface LicenseHistoryService {
    boolean recordLicenseChange(
            License license, ApplicationUser owner,
            String status, String description);
    Optional<LicenseHistory> findById(Long id);

    // save
    LicenseHistory save(DataLicenseHistoryRequest request);

    // read
    List<LicenseHistory> getAll();

    // update
    LicenseHistory update(DataLicenseHistoryRequest request);

    // delete
    void delete(Long id);
}
