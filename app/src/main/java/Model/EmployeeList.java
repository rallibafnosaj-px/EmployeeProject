package Model;

public class EmployeeList {

    String ID;
    String Firstname;
    String Lastname;


    public EmployeeList(String ID, String firstname, String lastname) {
        this.ID = ID;
        Firstname = firstname;
        Lastname = lastname;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }






}
