package dev.dani.backend.controller;

import dev.dani.backend.model.Country;
import dev.dani.backend.service.Impl.CountryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

 final private CountryServiceImpl countryService;

    public CountryController(CountryServiceImpl countryService) {
        this.countryService = countryService;
    }

    @GetMapping("")
    public ResponseEntity<List<Country>> getAllTutorials(
            @RequestParam(required = false) String name) {
        try {
            List<Country> countries= new ArrayList<Country>();

            if (name == null)
                countryService.findAll().forEach(countries::add);
            else
                countryService.findByNameContainingIgnoreCase(name).forEach(countries::add);

            if (countries.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(countries, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        try {
            Country _country = countryService.saveCountry(new Country(country.getId(), country.getName()));
            return new ResponseEntity<>(_country, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
