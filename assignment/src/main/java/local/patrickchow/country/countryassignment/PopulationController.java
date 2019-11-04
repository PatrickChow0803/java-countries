package local.patrickchow.country.countryassignment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController {

    @GetMapping(value = "/size/{people}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByPopulation(@PathVariable long people){
        ArrayList<Country> rtnCountries = CountryAssignmentApplication.ourCountryList
                .findCountries(c -> c.getPopulation() >= people);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/min",
                produces = {"application/json"})
    public ResponseEntity<?> getLowestPopulation(){
        Country lowestPopulationCountry = CountryAssignmentApplication.ourCountryList.countryList.get(0);
        for(Country currentCountry: CountryAssignmentApplication.ourCountryList.countryList){
            if(lowestPopulationCountry.getPopulation() >= currentCountry.getPopulation())
                lowestPopulationCountry = currentCountry;
        }

        return new ResponseEntity<>(lowestPopulationCountry, HttpStatus.OK);
    }

    @GetMapping(value = "/max",
                produces = {"application/json"})
    public ResponseEntity<?> getHighestPopulation(){
        Country highestPopulationCountry = CountryAssignmentApplication.ourCountryList.countryList.get(0);
        for(Country currentCountry: CountryAssignmentApplication.ourCountryList.countryList){
            if(highestPopulationCountry.getPopulation() <= currentCountry.getPopulation())
                highestPopulationCountry = currentCountry;
        }
        return new ResponseEntity<>(highestPopulationCountry, HttpStatus.OK);
    }
}
