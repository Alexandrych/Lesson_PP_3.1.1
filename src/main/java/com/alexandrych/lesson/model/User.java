package com.alexandrych.lesson.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Поле \"имя\" не должно оставаться пустым")
    private String firstName;

    @NotEmpty(message = "Поле \"фамилия\" не должно оставаться пустым")
    private String secondName;

    @Min(value = 0, message = "Возраст не может быть меньше 0")
    @Max(value = 120, message = "Возраст не может быть больше 120")
    private byte age;

    public User() {

    }

    public User(String firstName, String secondName, byte age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nИмя: " + firstName +
                "\nФамилия: " + secondName +
                "\nВозраст: " + age +
                "\n\n";
    }
}
