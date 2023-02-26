package org.example.inbound.rest;

import org.example.consultant.model.Competence;
import org.example.consultant.model.Consultant;
import org.example.consultant.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/consultants")
public class ConsultantController {

    @Autowired
    private ConsultantService consultantService;

    @PostMapping("/register")
    public ResponseEntity<Consultant> registerConsultant(@RequestBody Consultant consultant) {
        Consultant registeredConsultant = consultantService.registerConsultant(consultant);
        return ResponseEntity.ok(registeredConsultant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consultant> updateConsultant(@PathVariable Long id, @RequestBody Consultant consultant) {
        Consultant updatedConsultant = consultantService.updateConsultant(id, consultant);
        return ResponseEntity.ok(updatedConsultant);
    }

    @GetMapping("/search/{competence}")
    public ResponseEntity<List<Consultant>> searchConsultants(@RequestParam("competences") Competence competences,
                                                              @RequestParam("disponibilite") LocalDate disponibilite) {
        List<Consultant> consultants = consultantService.searchConsultants(competences, disponibilite);
        return ResponseEntity.ok(consultants);
    }
}