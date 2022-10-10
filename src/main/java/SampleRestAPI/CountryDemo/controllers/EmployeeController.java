package SampleRestAPI.CountryDemo.controllers;


import SampleRestAPI.CountryDemo.beans.Country;
import SampleRestAPI.CountryDemo.beans.Employee;
import SampleRestAPI.CountryDemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    /*@Autowired
    EmployeeService employeeService;

    @GetMapping("/getallemployees")
    public List getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/getemployee/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id")int id){
        return  employeeService.getEmployeeById(id);
    }
    @GetMapping("/getemployee/employeename")
    public Employee getEmployeeByName(@RequestParam(value = "name") String employeeName) {
        return employeeService.getEmployeeByFirstName(employeeName);

    }
    @GetMapping("/getemployee/employeelastname")
    public Employee getEmployeeByLastName(@RequestParam(value = "name") String employeeLastname) {
        return employeeService.getEmployeeByLastName(employeeLastname);

    }

    @PostMapping("/addemployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/updateemployee")
    public Employee updateEmployee(@RequestBody Employee employee) {

        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("deleteemployee/{id}")
    public AddResponse deleteCEmployee(@PathVariable(value = "id")int id){

        return  employeeService.deleteEmployee(id);
    } */
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getallemployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return  new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
    @GetMapping("/getemployee/{id}")
    public ResponseEntity<List<Employee>> getEmployeeById(@PathVariable(value = "id")int id){
        return  new ResponseEntity<>((List<Employee>) employeeService.getEmployeeById(id), HttpStatus.OK);
    }
    @GetMapping("/getemployee/employeename")
    public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam(value = "name") String employeeName) {
        return  new ResponseEntity<>((List<Employee>) employeeService.getEmployeeByFirstName(employeeName), HttpStatus.OK);

    }
    @GetMapping("/getemployee/employeelastname")
    public ResponseEntity<List<Employee>> getEmployeeByLastName(@RequestParam(value = "name") String employeeLastname) {
        return  new ResponseEntity<>((List<Employee>) employeeService.getEmployeeByLastName(employeeLastname), HttpStatus.OK);

    }

    @PostMapping("/addemployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return  new ResponseEntity<Employee>( employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/updateemployee")
    public ResponseEntity<Employee>  updateEmployee(@RequestBody Employee employee) {

        return  new ResponseEntity<Employee>( employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("deleteemployee")
    public ResponseEntity<HttpStatus> deleteCEmployee(@RequestParam long id){

        return  new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
