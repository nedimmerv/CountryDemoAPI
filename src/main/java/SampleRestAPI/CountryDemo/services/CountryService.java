package SampleRestAPI.CountryDemo.services;

import SampleRestAPI.CountryDemo.beans.Country;
import SampleRestAPI.CountryDemo.controllers.AddResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@RequestMapping
public class CountryService {
    static HashMap<Integer, Country> countryIdMap;  // to create id

    public CountryService() {
        // we create hard coded data

        countryIdMap= new HashMap<Integer ,Country>();

        Country spainCountry = new Country(1, "Spain", "Madrid");
        Country ukCountry = new Country(2, "England", "London");
        Country portugalCountry = new Country(3, "Portugal", "Lisbon");
        Country indiaCountry = new Country(4, "India", "Delhi");
        Country turkeyCountry = new Country(5, "Turkey", "Ankara");

        countryIdMap.put(1, spainCountry);
        countryIdMap.put(2, ukCountry);
        countryIdMap.put(3, portugalCountry);
        countryIdMap.put(4, indiaCountry);
        countryIdMap.put(5, turkeyCountry);

    }

    public List getAllCountries() {  // end point

        List countries = new ArrayList(countryIdMap.values());

        return countries;

    }

    public Country getCountryByID(int id) {
        Country country = countryIdMap.get(id);
        return country;
    }

    public Country getCountryByName(String countryName) {

        Country country = null;
        for (int i : countryIdMap.keySet()) {
            if (countryIdMap.get(i).getCountryName().equals(countryName))
                country = countryIdMap.get(i);
        }
        return country;

    }

    public Country addCountry(Country country) {
        country.setId(getMaxId());
        countryIdMap.put(country.getId(), country);
        return country;
    }

    // Utility methods to get max ID
    public static int getMaxId() {
        int max = 0;
        for (int id : countryIdMap.keySet())
            if (max <= id)
                max = id;
        return max + 1;

    }

    public Country updateCountry(Country country) {
        if (country.getId() > 0)
            countryIdMap.put(country.getId(), country);
        return country;
    }

    public AddResponse deleteCountry(int id) {
        countryIdMap.remove(id);
        AddResponse addResponse = new AddResponse();
        addResponse.setMsg("Country Deleted Successfully!...");
        addResponse.setId(id);
        return addResponse;
    }
}
