package ru.spring.user.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String firstName; // имя
    private String lastName; //фамилия
    private String patronymic; //отчество
    private long phone; // телефон
    @Column(unique = true)
    private long profNumber; //проф номер
    private String faculty; //факультет
    private int course; //курс

    public User(String firstName, String lastName, String patronymic, long phone, long profNumber, String faculty, int course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.phone = phone;
        this.profNumber = profNumber;
        this.faculty = faculty;
        this.course = course;
    }

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getProfNumber() {
        return profNumber;
    }

    public void setProfNumber(long profNumber) {
        this.profNumber = profNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone=" + phone +
                ", profNumber=" + profNumber +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                '}';
    }
}


