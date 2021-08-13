package md.tekwill.domain;

public class EmployeeResponse {

    public final boolean status;
    public final Employee employee;
    public final String errorMessage;

    public EmployeeResponse(Employee employee) {

        this.status = true;
        this.employee = employee;
        this.errorMessage = null;
    }

    public EmployeeResponse(Exception exception) {

        this.status = false;
        this.employee = null;
        this.errorMessage = exception.getMessage();
    }

    public EmployeeResponse(boolean status) {

        this.status = status;
        this.employee = null;
        this.errorMessage = null;
    }
}
