/**
 * Course: F2025 MAD204-01 Java Development for MA
 * Assignment: 1 - Part A (People Management System)
 * Student Name: Ishmeet Singh
 * Student ID: A00202436
 * Date: October 6, 2025
 *
 * Description:
 * Represents a Student who is a Person and can be evaluated based on GPA.
 */

public class Student extends Person implements Evaluable {
    protected String program;
    protected int year;
    protected double gpa;

    public Student(int id, String name, int age, String program, int year, double gpa) {
        super(id, name, age);
        this.program = program;
        this.year = year;
        this.gpa = gpa;
    }

    // Overloaded constructor
    public Student(int id, String name, int age) {
        this(id, name, age, "Undeclared", 1, 0.0);
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + year + " year student in " + program + ".");
    }

    @Override
    public String evaluatePerformance() {
        if (gpa >= 3.7) return "Excellent";
        else if (gpa >= 3.0) return "Good";
        else if (gpa >= 2.0) return "Average";
        else return "Needs Improvement";
    }

    @Override
    public String toString() {
        return super.toString() + " | Program: " + program + " | Year: " + year + " | GPA: " + gpa;
    }
}
