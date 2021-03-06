package com.jointrivial.sourcemanager.nordigen.repository;

import com.jointrivial.sourcemanager.nordigen.model.entity.NordigenSupportedCountries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<NordigenSupportedCountries, String> {
}
