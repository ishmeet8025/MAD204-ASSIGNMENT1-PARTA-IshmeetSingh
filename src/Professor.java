/**
 * Course: F2025 MAD204-01 Java Development for MA
 * Assignment: 1 - Part A (People Management System)
 * Student Name: Ishmeet Singh
 * Student ID: A00202436
 * Date: October 6, 2025
 *
 * Description:
 * Represents a Professor who is a Person and can be evaluated
 * based on their academic contributions and teaching performance.
 */

public class Professor extends Person implements Evaluable {
    private String department;
    private String title;

    public Professor(int id, String name, int age, String department, String title) {
        super(id, name, age);
        this.department = department;
        this.title = title;
    }

    @Override
    public void introduce() {
        System.out.println("Hello, I'm Professor " + name + ", from the " + department + " department.");
    }

    @Override
    public String evaluatePerformance() {
        return "Performance: Excellent (Based on courses taught & research output)";
    }

    @Override
    public String toString() {
        return super.toString() + " | Department: " + department + " | Title: " + title;
    }
}
