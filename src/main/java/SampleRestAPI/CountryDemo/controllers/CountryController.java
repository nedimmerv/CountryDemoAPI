package SampleRestAPI.CountryDemo.controllers;


import SampleRestAPI.CountryDemo.beans.Country;
import SampleRestAPI.CountryDemo.beans.Employee;
import SampleRestAPI.CountryDemo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {
   /* @Autowired
    CountryService countryService;

    @GetMapping("/getcountries")
    public List getCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/getcountries/{id}")
    public Country getCountryById(@PathVariable(value = "id") int id) {
        return countryService.getCountryByID(id);

    }

    @GetMapping("/getcountries/countryname")
    public Country getCountryByName(@RequestParam(value = "name") String countryName) {
        return countryService.getCountryByName(countryName);

    }

    @PostMapping("/addcountry")
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping("/updatecountry")
    public Country updateCountry(@RequestBody Country country) {

        return countryService.updateCountry(country);

    }

    @DeleteMapping("deletecountry/{id}")
    public AddResponse deleteCountry(@PathVariable(value = "id")int id){

        return  countryService.deleteCountry(id);
    } */

    @Autowired
    CountryService countryService;

    @GetMapping("/getcountries")
    public ResponseEntity<List<Country>> getCountries() {
        return  new ResponseEntity<List<Country>>(countryService.getAllCountries(), HttpStatus.OK);
    }

    @GetMapping("/getcountries/{id}")
    public ResponseEntity<List<Country>> getCountryById(@PathVariable(value = "id") int id) {
        return  new ResponseEntity<>((List<Country>) countryService.getCountryByID(id), HttpStatus.OK);

    }

    @GetMapping("/getcountries/countryname")
    public ResponseEntity<List<Country>> getCountryByName(@RequestParam(value = "name") String countryName) {
        return  new ResponseEntity<>((List<Country>) countryService.getCountryByName(countryName), HttpStatus.OK);
    }

    @PostMapping("/addcountry")
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        return  new ResponseEntity<Country>( countryService.addCountry(country), HttpStatus.CREATED);
    }

    @PutMapping("/updatecountry")
    public ResponseEntity<Country> updateCountry(@RequestBody Country country) {

        return  new ResponseEntity<Country>( countryService.updateCountry(country), HttpStatus.OK);

    }

    @DeleteMapping("deletecountry")
    public ResponseEntity<HttpStatus> deleteCountry(@RequestParam long id){
        return  new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);

    }
}
