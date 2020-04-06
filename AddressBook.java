package ro.siit;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressBook {

    private static List<Student> students = new ArrayList<>();


    public static void createStudent(String firstName, String lastName, String dateOfBirth, boolean gender, String id){
        students.add(new Student(firstName, lastName, dateOfBirth, gender, id));
            if (firstName.equals("") && lastName.equals("")) {
                System.out.println("First name and last name are missing");
            } else {
                students.add(new Student(firstName, lastName, dateOfBirth, gender, id));
                System.out.println("Student added");
            }

    }

    public static void saveStudents(){
        Path studentsDB = Paths.get("resources" + File.separator + "students.db");

        try {
            Files.write(studentsDB, prepareStudentsForSave(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadStudent(){
        Path studentsDB = Paths.get("resources" + File.separator + "students.db");
        try {
            List<String> stringLines = Files.readAllLines(studentsDB, Charset.defaultCharset());
            for(String studentFromFile : stringLines){
                if(studentFromFile.indexOf("###") != -1) {
                   students.add(parseStudent(studentFromFile));
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   public static void deleteStudent(String firstName) {
        for (Iterator<Student> iterator = students.iterator(); iterator.hasNext();) {
            Student temp = iterator.next();
            if (temp.getFirstName().equalsIgnoreCase(firstName)) {
                iterator.remove();
                return;
            }
        }

        System.out.println("No contact with first name" + firstName + "was found.");
    }


    private static Student parseStudent(String studentAsString){
        String [] studentSplitted = studentAsString.split("###");
        return new Student(Integer.parseInt(studentSplitted[0]), studentSplitted[1], studentSplitted[2]);

    }

    private static List<String> prepareStudentsForSave(){
        List<String> stringStudents = new ArrayList<>();
        for(Student student: students){
            stringStudents.add(student.toString());
        }
        return stringStudents;
    }

    public static List<Student> getStudents(){
        List<Student> aux = new ArrayList<>();
        aux.addAll(students);
        return aux;
    }

}
