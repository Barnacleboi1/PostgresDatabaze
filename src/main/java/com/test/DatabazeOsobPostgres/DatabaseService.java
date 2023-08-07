package com.test.DatabazeOsobPostgres;

import com.test.DatabazeOsobPostgres.Exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    PersonRepository repository;
    @Autowired
    public DatabaseService(PersonRepository repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> addPerson(Person person) {
        if (!person.getPersonalNumber().matches("\\d{6}/?\\d{4}")) {
            throw new WrongIDFormatException("The personal number must be in the format YYMMDDXXXX or YYMMDD/XXXX");
        }
        if (repository.existsById(person.getPersonalNumber())){
            throw new AlreadyInDatabaseException("This person is already in the database");
        } else {
            repository.save(person);
            return ResponseEntity.ok("The person was added successfully");
        }
    }
    public ResponseEntity<?> removePerson(String personalNumber) {
        personalNumber = personalNumber.replace("/", "");
        if (!repository.existsById(personalNumber)) {
            throw new NotFoundException("This person was not found in the database");
        } else {
            repository.deleteById(personalNumber);
            return ResponseEntity.ok("The person was removed successfully");
        }
    }
    public Person searchPerson(String personalNumber) {
        personalNumber = personalNumber.replace("/", "");
        if (!repository.existsById(personalNumber)) {
            throw new NotFoundException("This person was not found in the database");
        } else {
            return repository.findById(personalNumber).get();
        }
    }
}
