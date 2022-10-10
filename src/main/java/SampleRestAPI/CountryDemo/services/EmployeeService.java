package SampleRestAPI.CountryDemo.services;


import SampleRestAPI.CountryDemo.beans.Employee;
import SampleRestAPI.CountryDemo.controllers.AddResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class EmployeeService {
    static HashMap<Integer, Employee> employeeIdMap;  // to create id

    public EmployeeService() {
        employeeIdMap = new HashMap<Integer, Employee>();
        Employee martaEmployee = new Employee(1, 125000, "Marta", "Costa");
        Employee vikasEmployee = new Employee(2, 125000, "Vikas", "Bhara");
        Employee jogaEmployee = new Employee(3, 125000, "Joga", "Roa");
        Employee baronEmployee = new Employee(5, 125000, "Guliherme", "Baron");
        Employee nedimEmployee = new Employee(5, 125000, "Nedim", "Yilmaz");

        employeeIdMap.put(1, martaEmployee);
        employeeIdMap.put(2, vikasEmployee);
        employeeIdMap.put(3, jogaEmployee);
        employeeIdMap.put(4, baronEmployee);
        employeeIdMap.put(5, nedimEmployee);
    }

    public List getAllEmployees() {
        List employees = new ArrayList(employeeIdMap.values());
        return employees;

    }

    public Employee getEmployeeById(int id) {
        Employee employee = employeeIdMap.get(id);
        return employee;
    }

    public Employee getEmployeeByFirstName(String employeeName) {
        Employee employee = null;
        for (int i : employeeIdMap.keySet()) {
            if (employeeIdMap.get(i).getEmployee_firstname().equals(employeeName))
                employee = employeeIdMap.get(i);
        }
        return employee;
    }

    public Employee getEmployeeByLastName(String employeeLastname) {
        Employee employee = null;
        for (int i : employeeIdMap.keySet()) {
            if (employeeIdMap.get(i).getEmployee_lastname().equals(employeeLastname))
                employee = employeeIdMap.get(i);
        }
        return employee;
    }

    // Utility methods to get max ID
    public static int getMaxId() {
        int max = 0;
        for (int id : employeeIdMap.keySet())
            if (max <= id)
                max = id;
        return max + 1;

    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployee_id(getMaxId());
        employeeIdMap.put(employee.getEmployee_id(), employee);
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        if (employee.getEmployee_id() > 0)
            employeeIdMap.put(employee.getEmployee_id(), employee);
        return employee;
    }

    public AddResponse deleteEmployee(int id) {
        employeeIdMap.remove(id);
        AddResponse addResponse = new AddResponse();
        addResponse.setMsg("Employee Deleted!...");
        addResponse.setId(id);
        return addResponse;
    }
}
