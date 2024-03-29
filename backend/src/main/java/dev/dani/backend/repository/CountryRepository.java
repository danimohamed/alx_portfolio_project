package dev.dani.backend.repository;

import dev.dani.backend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByNameContainingIgnoreCase(String title);
}