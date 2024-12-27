package ru.mtuci.volovodovskiy.repository;

import ru.mtuci.volovodovskiy.model.LicenseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseHistoryRepository extends JpaRepository<LicenseHistory, Long> {
}
