package de.aittr.g_31_2_rest.domain;

import java.util.Objects;

public class Dog {
    private int id;
    private String name;
    private int age;
    private String breed;
    private String color;
    private double weight;

    public Dog() {
    }

    public Dog(String name, int age, String breed, String color, double weight) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.color = color;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return id == dog.id && age == dog.age && Double.compare(dog.weight, weight) == 0 && Objects.equals(name, dog.name) && Objects.equals(breed, dog.breed) && Objects.equals(color, dog.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, breed, color, weight);
    }
    @Override
    public String toString() {
        return String.format("Собака: ИД - %d, кличка - %s, возраст - %d, порода - %s, цвет - %s, вес - %.3f",
                id, name, age, breed, color, weight);
    }
}
