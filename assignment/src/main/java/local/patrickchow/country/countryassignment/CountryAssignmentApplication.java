package local.patrickchow.country.countryassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryAssignmentApplication {

    static CountryList ourCountryList;

    public static void main(String[] args) {

        ourCountryList = new CountryList();

        SpringApplication.run(CountryAssignmentApplication.class, args);



    }

}
