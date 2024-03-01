package dev.dani.backend.service.Impl;

import dev.dani.backend.model.Country;
import dev.dani.backend.repository.CountryRepository;
import dev.dani.backend.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    final private CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    /**
     * @Description Search all country by name
     * @return List<Country>
     */
    @Override
    public List<Country> findByNameContainingIgnoreCase(String name) {
        return countryRepository.findByNameContainingIgnoreCase(name);
    }

    /**
     * @Description Search all country
     * @return List<Country>
     */
    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    /**
     * @Description Create country
     * @param country
     * @return Country
     */
    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }
}
