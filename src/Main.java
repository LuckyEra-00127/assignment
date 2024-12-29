import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    String name;
    String surname;
    int age;
    boolean gender;

    public Person(String name, String surname, int age, boolean gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }git init

    public String toString() {
        return "Hi, I am " + name + " " + surname + ", a " + age + "-year-old " + (gender ? "Male" : "Female") + ".";
    }
}

class Student extends Person {
    static int nextID = 1;
    int studentID;
    List<Integer> grades;

    public Student(String name, String surname, int age, boolean gender, List<Integer> grades) {
        super(name, surname, age, gender);
        this.studentID = nextID++;
        this.grades = grades;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double calculateGPA() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / (double) grades.size();
    }

    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + ".";
    }
}

class Teacher extends Person {
    String subject;
    int yearsOfExperience;
    int salary;

    public Teacher(String name, String surname, int age, boolean gender, String subject, int yearsOfExperience, int salary) {
        super(name, surname, age, gender);
        this.subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public void giveRaise(double percentage) {
        salary += salary * percentage / 100;
    }

    public String toString() {
        return super.toString() + " I teach " + subject + ".";
    }
}

class School {
    List<Person> members;

    public School() {
        members = new ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person member : members) {
            sb.append(member.toString()).append("\n");
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        School school = new School();

        List<Integer> grades1 = List.of(78, 89, 99, 51);
        List<Integer> grades2 = List.of(78, 89, 75, 63, 82);
        List<Integer> grades3 = List.of(100, 99, 95, 98, 100, 96, 97);
        List<Integer> grades4 = List.of(46, 87, 67, 79, 96, 58, 83);
        List<Integer> grades5 = List.of(21, 45, 0, 9, 51, 43);

        Student student1 = new Student("Harry", "Potter", 21, true, grades1);
        Student student2 = new Student("Ron", "Qeasley", 20, true, grades2);
        Student student3 = new Student("Hermione", "Granger", 19, false, grades3);
        Student student4 = new Student("Luna", "Lovegood", 20, false, grades4);
        Student student5 = new Student("Draco", "Malfoy", 19, true, grades5);

        school.addMember(student1);
        school.addMember(student2);
        school.addMember(student3);
        school.addMember(student4);
        school.addMember(student5);

        Teacher teacher1 = new Teacher("Severus", "Snape", 51, true, "Math", 7, 800000);
        Teacher teacher2 = new Teacher("Albus", "Dumbledore", 71, true, "Philosophy", 25, 1500000);
        Teacher teacher3 = new Teacher("Minerva", "McGonagall", 62, false, "Sociology", 17, 1100000);
        Teacher teacher4 = new Teacher("Bellatrix", "Lestrange", 35, false, "Programming", 3, 570000);
        Teacher teacher5 = new Teacher("Sirius", "Black", 49, true, "Physics", 9, 750000);

        school.addMember(teacher1);
        school.addMember(teacher2);
        school.addMember(teacher3);
        school.addMember(teacher4);
        school.addMember(teacher5);

        for (Teacher teacher : new Teacher[]{teacher1, teacher2, teacher3, teacher4, teacher5}) {
            if (teacher.yearsOfExperience > 10) {
                teacher.giveRaise(10);
            }
        }

        System.out.println(school);

        for (Student student : new Student[]{student1, student2, student3, student4, student5}) {
            System.out.println(student.calculateGPA());
        }
    }
}
