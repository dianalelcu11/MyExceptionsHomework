package ro.siit;

public class Student {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private boolean gender;
    private String id;

    public Student(String firstName, String lastName, String dateOfBirth, boolean gender, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
        if (gender = f) {
            System.out.print("female");
        } else if (gender = m) {
            System.out.print("male");
        }

    }


    public void setId(String id) {
        this.id = id;
    }


    public String toString() {
        return this.firstName + "###" + this.lastName + "###" + this.dateOfBirth + "###" + this.gender + "###" + this.id;
    }

}



