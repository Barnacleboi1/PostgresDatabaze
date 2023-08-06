package com.test.DatabazeOsobPostgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DatabazeService {
    @Autowired
    OsobRepository repository;

    public ResponseEntity<?> pridejOsobu(Osoba osoba) {
        repository.save(osoba);
    }
    public ResponseEntity<?> odeberOsobu(String rodneCislo) {

    }
    public ResponseEntity<?> vyhledejOsobu(String rodneCislo) {

    }
}
