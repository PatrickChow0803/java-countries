package local.patrickchow.country.countryassignment;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class NameController {

    @GetMapping(value = "/all",
                produces = {"application/json"})
    public ResponseEntity<?> getAllCountries(){
        CountryAssignmentApplication.ourCountryList.countryList
                .sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountryAssignmentApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    @GetMapping(value = "/start/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLetter(@PathVariable char letter){
        ArrayList<Country> rtnCountries = CountryAssignmentApplication.ourCountryList
                .findCountries(e -> e.getName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    @GetMapping(value = "/size/{number}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesBySize(@PathVariable int number){
        ArrayList<Country> rtnCountries = CountryAssignmentApplication.ourCountryList
                .findCountries(e -> e.getName().length() >= number);
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

}
