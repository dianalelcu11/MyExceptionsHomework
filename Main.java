package ro.siit;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class Main {

    static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static String main(String[] args) {


        logger.log(Level.DEBUG, "This is debug message");


        AddressBook.loadStudent();
        Scanner keyboard = new Scanner(System.in);
        String cmd;
        do {
            System.out.println("A - for adding students");
            System.out.println("D - for deleting students");
            System.out.println("L - for retrieving all students");
            cmd = keyboard.nextLine();

            switch (cmd.toUpperCase()) {
                case "A":
                    System.out.println("Student's first name?");
                    String firstName = keyboard.nextLine();
                    System.out.println("Student's last name?");
                    String lastName = keyboard.nextLine();
                    System.out.println("Date of birth?");
                    String dateOfBirth = keyboard.nextLine();
                    System.out.println("Gender?");
                    String gender = keyboard.nextLine();
                    System.out.println("ID?");
                    String id = keyboard.nextLine();
                    AddressBook.createStudent(firstName, lastName, dateOfBirth, gender, id);
                    try {
                        if (firstName != null)
                            return firstName;
                        } catch (IllegalArgumentException e) {
                        return firstName;
                        }
                    break;
                case "D":
                    AddressBook.deleteStudent();
                    break;
                case "L":
                    List<Student> students = AddressBook.getStudents();
                    for (Student student : students) {
                        System.out.println(student);
                    }
            }

        } while (!cmd.equalsIgnoreCase("x"));
    }


}


















        /* Scanner keyboard = new Scanner(System.in);
        boolean ok;
        do {
            System.out.println("Dati un numar");
            String number = keyboard.nextLine();

            Integer nr;
            try{
                nr = Integer.parseInt(number);
                System.out.println(2*nr);
                ok = true;
            } catch (NumberFormatException nfex) {
                ok = false;
                System.out.println("Nr invalid");
            }
        } while(!ok);

    }*/




