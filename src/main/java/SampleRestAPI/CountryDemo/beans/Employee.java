package SampleRestAPI.CountryDemo.beans;

public class Employee {
    int employee_id;
    int employee_salary;
    String employee_firstname;

    public Employee(int employee_id, int employee_salary, String employee_firstname, String employee_lastname) {
        this.employee_id = employee_id;
        this.employee_salary = employee_salary;
        this.employee_firstname = employee_firstname;
        this.employee_lastname = employee_lastname;
    }

    String employee_lastname;

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(int employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_firstname() {
        return employee_firstname;
    }

    public void setEmployee_firstname(String employee_firstname) {
        this.employee_firstname = employee_firstname;
    }

    public String getEmployee_lastname() {
        return employee_lastname;
    }

    public void setEmployee_lastname(String employee_lastname) {
        this.employee_lastname = employee_lastname;
    }
}
