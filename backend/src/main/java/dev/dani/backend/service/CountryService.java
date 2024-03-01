package dev.dani.backend.service;

import dev.dani.backend.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findByNameContainingIgnoreCase(String title);
    List<Country> findAll();

    Country saveCountry(Country country);
}
