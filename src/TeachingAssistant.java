/**
 * Course: F2025 MAD204-01 Java Development for MA
 * Assignment: 1 - Part A (People Management System)
 * Student Name: Ishmeet Singh
 * Student ID: A00202436
 * Date: October 6, 2025
 *
 * Description:
 * Represents a Teaching Assistant who is both a Student and performs
 * teaching-related duties. Their performance is based on GPA and assigned duties.
 */

public class TeachingAssistant extends Student {
    private String assignedCourse;

    public TeachingAssistant(int id, String name, int age, String program, int year, double gpa, String assignedCourse) {
        super(id, name, age, program, year, gpa);
        this.assignedCourse = assignedCourse;
    }

    @Override
    public void introduce() {
        System.out.println("I'm " + name + ", a TA for " + assignedCourse + " and a student in " + program + ".");
    }

    @Override
    public String evaluatePerformance() {
        if (gpa >= 3.5) return "Outstanding TA";
        else if (gpa >= 3.0) return "Good TA";
        else return "Satisfactory TA";
    }

    @Override
    public String toString() {
        return super.toString() + " | Assigned Course: " + assignedCourse;
    }
}
