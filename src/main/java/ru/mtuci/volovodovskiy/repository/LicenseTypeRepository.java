package ru.mtuci.volovodovskiy.repository;

import ru.mtuci.volovodovskiy.model.LicenseType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseTypeRepository extends JpaRepository<LicenseType, Long> {
}
