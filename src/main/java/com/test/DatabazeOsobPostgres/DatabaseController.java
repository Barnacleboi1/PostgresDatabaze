package com.test.DatabazeOsobPostgres;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/osoba")
public class DatabaseController {

    DatabaseService databazeService = new DatabaseService();

    @PostMapping
    public ResponseEntity<?> pridejOsobu(@RequestBody Person osoba)  {
        try {
            return databazeService.addPerson(osoba);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Osoba nebyla přidána: " + e.getMessage());
        }
    }
    @DeleteMapping("/{rodneCislo}")
    public ResponseEntity<?> odeberOsobu(@PathVariable String rodneCislo) {
        try {
            return databazeService.removePerson(rodneCislo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Osoba nebyla úspěšně odebrána: " + e.getMessage());
        }
    }
    @GetMapping("/{rodneCislo}")
    public ResponseEntity<?> vyhledejOsobu(@PathVariable String rodneCislo) {
        try {
            return databazeService.searchPerson(rodneCislo);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Osoba nebyla vyhledána: " + e.getMessage());
        }
    }
}
