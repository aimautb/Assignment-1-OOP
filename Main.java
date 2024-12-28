import Modelik.Person;
import Modelik.School;
import Modelik.Student;
import Modelik.Teacher;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/students (1).txt");
        Scanner sc = new Scanner(file);
        File file2 = new File("src/teachers.txt");
        Scanner sc2 = new Scanner(file2);

        School school = new School();

        while (sc.hasNext()) {
            String comma = sc.nextLine();
            if(comma.trim().isEmpty()) {
                continue;
            }

            String[] arr = comma.split(" ");

            if (arr.length < 4) {
                System.out.println("not enough info for student: " + comma);
                continue;
            }

            String name = arr[0];
            String surname = arr[1];
            int age = Integer.parseInt(arr[2]);
            boolean gender = arr[3].equalsIgnoreCase("Male");

            ArrayList<Integer> grades = new ArrayList<>();
            Student student = new Student(name, surname, age, gender, grades);

            for (int i = 4; i < arr.length; i++) {
                student.addGrade(Integer.parseInt(arr[i])); // IDE помогла)
            }

            school.addMember(student);
        }




        while (sc2.hasNext()) {
            String comma = sc2.nextLine();
            if (comma.trim().isEmpty()) {
                continue;
            }
            String[] arr = comma.split(" ");

            if (arr.length < 7) {
                System.out.println("not enough info for teacher");
                continue;
            }
            String name = arr[0];
            String surname = arr[1];
            int age = Integer.parseInt(arr[2]);
            boolean gender = arr[3].equalsIgnoreCase("Male");
            String subject = arr[4];
            int yearsOfExperience = Integer.parseInt(arr[5]);
            int salary = Integer.parseInt(arr[6]);

            Teacher teacher = new Teacher(name, surname, age, gender, subject, yearsOfExperience, salary);
            school.addMember(teacher);


            teacher.giveRaise(50);

        }


        sc.close();
        sc2.close();

        System.out.println("School:");
        System.out.println(school)  ;
    }
}