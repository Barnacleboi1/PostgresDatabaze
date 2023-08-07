package com.test.DatabazeOsobPostgres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
public class DatabaseController {

    DatabaseService databazeService;

    @Autowired
    public DatabaseController(DatabaseService databazeService) {
        this.databazeService = databazeService;
    }

    @PostMapping
    public ResponseEntity<?> addPerson(@RequestBody Person person)  {
        return databazeService.addPerson(person);
    }
    @DeleteMapping("/{personalNumber}")
    public ResponseEntity<?> removePerson(@PathVariable String personalNumber) {
        return databazeService.removePerson(personalNumber);
    }
    @GetMapping("/{personalNumber}")
    public Person searchPerson(@PathVariable String personalNumber) {
        return databazeService.searchPerson(personalNumber);
    }
}
