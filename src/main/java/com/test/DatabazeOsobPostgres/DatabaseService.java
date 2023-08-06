package com.test.DatabazeOsobPostgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    @Autowired
    PersonRepository repository;

    public ResponseEntity<?> addPerson(Person person) {
        repository.save(person);
    }
    public ResponseEntity<?> removePerson(String personalNumber) {

    }
    public ResponseEntity<?> searchPerson(String personalNumber) {

    }
}
