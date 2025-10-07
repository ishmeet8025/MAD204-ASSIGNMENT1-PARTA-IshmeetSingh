/**
 * Course: F2025 MAD204-01 Java Development for MA
 * Assignment: 1 - Part A (People Management System)
 * Student Name: Ishmeet Singh
 * Student ID: A00202436
 * Date: October 6, 2025
 *
 * Description:
 * Abstract class representing a person with common fields and behaviors.
 * Used as a base class for Student, Professor, and TeachingAssistant.
 */

import java.io.Serializable;

public abstract class Person implements Serializable {
    protected int id;
    protected String name;
    protected int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void celebrateBirthday() {
        age++;
        System.out.println(name + " has turned " + age + " years old! 🎉");
    }

    public abstract void introduce();

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Age: " + age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
