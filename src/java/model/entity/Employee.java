package model.entity.BO;
/**
 *
 * @author Cy
 */
public class Employee {


    private int employeeId;
    private String employeeLogin;
    private String employeePassword;
    private String employeeDateStart;
    private String employeeDateEnd;
    
    public Employee(){
        
    }
    public Employee(int employeeId, String employeeLogin, String employeePassword, String employeeDateStart, String employeeDateEnd){
        
    }
    public Employee(String employeeLogin, String employeePassword, String employeeDateStart, String employeeDateEnd){
        
    }    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeLogin() {
        return employeeLogin;
    }

    public void setEmployeeLogin(String employeeLogin) {
        this.employeeLogin = employeeLogin;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeDateStart() {
        return employeeDateStart;
    }

    public void setEmployeeDateStart(String employeeDateStart) {
        this.employeeDateStart = employeeDateStart;
    }

    public String getEmployeeDateEnd() {
        return employeeDateEnd;
    }

    public void setEmployeeDateEnd(String employeeDateEnd) {
        this.employeeDateEnd = employeeDateEnd;
    }

    @Override
    public String toString() {
        return employeeLogin+" "+employeePassword;
    }

}