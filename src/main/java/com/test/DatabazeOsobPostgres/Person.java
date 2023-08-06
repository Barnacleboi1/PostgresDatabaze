package com.test.DatabazeOsobPostgres;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.Period;

@Entity(name = "Person")
public class Person {
    @Id
    @Column(
            name = "personal_number",
            nullable = false
    )
    private String personalNumber;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name = "surname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String surname;
    @Column(
            name = "age",
            nullable = false
    )
    private int age;
    public Person(String name, String surname, String personalNumber) {
        this.name = name;
        this.surname = surname;
        this.personalNumber = personalNumber.replace("/", "");
        this.age = vypocetVeku();
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }
    public int vypocetVeku() {
        int stoletiNarozeni;

        if (LocalDate.now().getYear() - Integer.parseInt(personalNumber.substring(0, 2)) < 2000) {
            stoletiNarozeni = 19;
        } else {
            stoletiNarozeni = 20;
        }

        int rokNarozeni = Integer.parseInt(stoletiNarozeni + personalNumber.substring(0, 2));
        int mesicNarozeni = Integer.parseInt(personalNumber.substring(2, 4));
        int denNarozeni = Integer.parseInt(personalNumber.substring(4, 6));

        LocalDate datumNarozeni = LocalDate.of(rokNarozeni, mesicNarozeni, denNarozeni);

        int vek = Period.between(datumNarozeni, LocalDate.now()).getYears();
        return vek;
    }
}
