package com.test.DatabazeOsobPostgres;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.Period;

@Entity(name = "Osoba")
public class Osoba {
    @Id
    @Column(
            name = "rodne_cislo",
            nullable = false
    )
    private String rodneCislo;
    @Column(
            name = "jmeno",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String jmeno;
    @Column(
            name = "prijmeni",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String prijmeni;
    @Column(
            name = "vek",
            nullable = false
    )
    private int vek;
    public Osoba(String jmeno, String prijmeni, String rodneCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.rodneCislo = rodneCislo.replace("/", "");
        this.vek = vypocetVeku();
    }

    public Osoba() {
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public String getRodneCislo() {
        return rodneCislo;
    }
    public int vypocetVeku() {
        int stoletiNarozeni;

        if (LocalDate.now().getYear() - Integer.parseInt(rodneCislo.substring(0, 2)) < 2000) {
            stoletiNarozeni = 19;
        } else {
            stoletiNarozeni = 20;
        }

        int rokNarozeni = Integer.parseInt(stoletiNarozeni + rodneCislo.substring(0, 2));
        int mesicNarozeni = Integer.parseInt(rodneCislo.substring(2, 4));
        int denNarozeni = Integer.parseInt(rodneCislo.substring(4, 6));

        LocalDate datumNarozeni = LocalDate.of(rokNarozeni, mesicNarozeni, denNarozeni);

        int vek = Period.between(datumNarozeni, LocalDate.now()).getYears();
        return vek;
    }
}
