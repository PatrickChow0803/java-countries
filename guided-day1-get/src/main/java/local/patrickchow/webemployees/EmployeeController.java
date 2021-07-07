package local.patrickchow.webemployees;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// Classes with annotations in beginning are considered Beans
// Java Spring Bean
@RestController
@RequestMapping("/data") // Means that all the methods will start with data
public class EmployeeController {

    // Get all the employees sorted by first name
    // localhost:2019/data/allemployees
    //@GetMapping = When you reach this endpoint, do this block of code
    // ? = Wild Card. Don't know what it contains for now, we'll deal with it later
    @GetMapping(value = "/allemployees",
            produces = {"application/json"})
    public ResponseEntity<?> getAllEmployees() {
        WebEmployeesApplication.ourEmpList.empList.sort((e1, e2) -> e1.getFname().compareToIgnoreCase(e2.getFname()));
        return new ResponseEntity<>(WebEmployeesApplication.ourEmpList.empList, HttpStatus.OK);
    }

    // Get the employee with the corresponding ID
    // localhost:2019/data/employee/2
    // Braces = Path Variable. Will change depending on what value is passed
    @GetMapping(value = "/employee/{empid}",
                produces = {"application/json"})
    public ResponseEntity<?> getEmpDetail(@PathVariable long empid) {
        Employee rtnEmp = WebEmployeesApplication.ourEmpList.findEmployee(e -> (e.getId() == empid));
        return new ResponseEntity<>(rtnEmp, HttpStatus.OK);
    }

    // Get employees that start with the letter s and sort it by salary
    // localhost:2019/data/employees/s
    @GetMapping(value = "/employees/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getSortedEmployees(@PathVariable char letter){
        ArrayList<Employee> rtnEmps = WebEmployeesApplication.ourEmpList
                .findEmployees(e -> e.getFname().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnEmps.sort((e1, e2) -> ((int) (e1.getSalary() - e2.getSalary())));
        return new ResponseEntity<>(rtnEmps, HttpStatus.OK);
    }
}
