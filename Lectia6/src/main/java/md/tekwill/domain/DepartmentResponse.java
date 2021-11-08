package md.tekwill.domain;

public class DepartmentResponse {

    public final boolean status;
    public final Department department;
    public final String errorMessage;

    public DepartmentResponse(Department department) {

        this.status = true;
        this.department = department;
        this.errorMessage = null;
    }

    public DepartmentResponse(Exception exception) {

        this.status = false;
        this.department = null;
        this.errorMessage = exception.getMessage();
    }

    public DepartmentResponse(boolean status) {

        this.status = status;
        this.department = null;
        this.errorMessage = null;
    }
}
