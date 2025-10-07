/**
 * Course: F2025 MAD204-01 Java Development for MA
 * Assignment: 1 - Part A (People Management System)
 * Student Name: Ishmeet Singh
 * Student ID: A00202436
 * Date: October 6, 2025
 *
 * Description:
 * Entry point for the People Management System. Provides a console-based menu
 * that allows adding, listing, searching, removing, and evaluating people.
 * Demonstrates recursion, file I/O, and exception handling.
 */

import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Person> people = new ArrayList<>();
    private static final String FILE_NAME = "people.txt";
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadPeople();
        int choice;

        do {
            System.out.println("\n=== People Management System ===");
            System.out.println("1. Add Person");
            System.out.println("2. List People");
            System.out.println("3. Search Person by ID");
            System.out.println("4. Search Person by Name");
            System.out.println("5. Remove Person");
            System.out.println("6. Celebrate Birthday");
            System.out.println("7. Show Performance Evaluation");
            System.out.println("8. Run Countdown (Recursion Demo)");
            System.out.println("9. Save & Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> addPerson();
                    case 2 -> listPeople();
                    case 3 -> searchById();
                    case 4 -> searchByName();
                    case 5 -> removePerson();
                    case 6 -> celebrateBirthday();
                    case 7 -> showPerformance();
                    case 8 -> runCountdown();
                    case 9 -> savePeople();
                    default -> System.out.println("Invalid choice, please try again!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number between 1–9.");
                choice = 0;
            }
        } while (choice != 9);
    }

    // ---------------------- CRUD ----------------------
    private static void addPerson() {
        try {
            System.out.println("\nSelect Type: 1) Student 2) Professor 3) Teaching Assistant");
            int type = Integer.parseInt(sc.nextLine());
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = Integer.parseInt(sc.nextLine());
            if (age <= 0) throw new IllegalArgumentException("Age must be positive!");

            switch (type) {
                case 1 -> {
                    System.out.print("Enter Program: ");
                    String program = sc.nextLine();
                    System.out.print("Enter Year: ");
                    int year = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter GPA: ");
                    double gpa = Double.parseDouble(sc.nextLine());
                    if (gpa < 0 || gpa > 4.0) throw new IllegalArgumentException("GPA must be between 0–4.0");
                    people.add(new Student(id, name, age, program, year, gpa));
                }
                case 2 -> {
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    people.add(new Professor(id, name, age, dept, title));
                }
                case 3 -> {
                    System.out.print("Enter Program: ");
                    String program = sc.nextLine();
                    System.out.print("Enter Year: ");
                    int year = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter GPA: ");
                    double gpa = Double.parseDouble(sc.nextLine());
                    System.out.print("Enter Assigned Course: ");
                    String course = sc.nextLine();
                    people.add(new TeachingAssistant(id, name, age, program, year, gpa, course));
                }
                default -> System.out.println("Invalid type!");
            }
        } catch (Exception e) {
            System.out.println("Error adding person: " + e.getMessage());
        }
    }

    private static void listPeople() {
        if (people.isEmpty()) System.out.println("No people found!");
        else people.forEach(System.out::println);
    }

    private static void searchById() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Person p = search(id);
        System.out.println(p != null ? p : "No match found!");
    }

    private static void searchByName() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        Person p = search(name);
        System.out.println(p != null ? p : "No match found!");
    }

    private static void removePerson() {
        System.out.print("Enter ID to remove: ");
        int id = Integer.parseInt(sc.nextLine());
        Person p = search(id);
        if (p != null) {
            people.remove(p);
            System.out.println("Person removed successfully!");
        } else System.out.println("No person found with that ID!");
    }

    // ---------------------- Overloaded Search ----------------------
    private static Person search(int id) {
        for (Person p : people) if (p.getId() == id) return p;
        return null;
    }

    private static Person search(String name) {
        for (Person p : people) if (p.getName().equalsIgnoreCase(name)) return p;
        return null;
    }

    private static void celebrateBirthday() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Person p = search(id);
        if (p != null) p.celebrateBirthday();
        else System.out.println("Person not found!");
    }

    private static void showPerformance() {
        for (Person p : people) {
            if (p instanceof Evaluable e)
                System.out.println(p.getName() + ": " + e.evaluatePerformance());
        }
    }

    // ---------------------- Recursion ----------------------
    private static void runCountdown() {
        System.out.print("Enter number to start countdown: ");
        int n = Integer.parseInt(sc.nextLine());
        countdown(n);
        System.out.println("Factorial of " + n + " = " + factorial(n));
    }

    private static void countdown(int n) {
        if (n < 0) return;
        System.out.println(n);
        countdown(n - 1);
    }

    private static int factorial(int a) {
        if (a <= 1) return 1;
        return a * factorial(a - 1);
    }

    // ---------------------- File I/O ----------------------
    private static void savePeople() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(people);
            System.out.println("Data saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void loadPeople() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            people = (ArrayList<Person>) in.readObject();
            System.out.println("Loaded " + people.size() + " people from file.");
        } catch (Exception e) {
            System.out.println("No previous data found. Starting fresh.");
        }
    }
}
