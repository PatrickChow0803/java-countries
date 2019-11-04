package local.patrickchow.country.countryassignment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class AgeController {

    @GetMapping(value = "/age/{age}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByAge(@PathVariable double age){
        ArrayList<Country> medianCountries = CountryAssignmentApplication.ourCountryList
                .findCountries(c1-> c1.getMedianAge() >= age);
        return new ResponseEntity<>(medianCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/age/min",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByLowestAge(){
        Country lowestAgeCountry = CountryAssignmentApplication.ourCountryList.countryList.get(0);
        for(Country currentCountry: CountryAssignmentApplication.ourCountryList.countryList){
            if(lowestAgeCountry.getMedianAge() >= currentCountry.getMedianAge())
                lowestAgeCountry = currentCountry;
        }
        return new ResponseEntity<>(lowestAgeCountry, HttpStatus.OK);
    }

    @GetMapping(value = "/age/max",
                produces = {"application/json"})
    public ResponseEntity<?> getCountryByHighestAge(){
        Country highestAgeCountry = CountryAssignmentApplication.ourCountryList.countryList.get(0);
        for(Country currentCountry: CountryAssignmentApplication.ourCountryList.countryList){
            if(highestAgeCountry.getMedianAge() <= currentCountry.getMedianAge())
                highestAgeCountry = currentCountry;
        }
        return new ResponseEntity<>(highestAgeCountry, HttpStatus.OK);
    }
}
