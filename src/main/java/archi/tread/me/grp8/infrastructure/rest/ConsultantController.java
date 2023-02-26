package archi.tread.me.grp8.infrastructure.rest;

import archi.tread.me.grp8.domain.consultant.model.Consultant;
import archi.tread.me.grp8.domain.consultant.model.Competence;
import archi.tread.me.grp8.domain.consultant.service.ConsultantService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/consultants")
@AllArgsConstructor
public class ConsultantController {

    private final ConsultantService consultantService;

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

    @PostMapping("/search/name")
    public ResponseEntity<List<Consultant>> searchByName(@RequestBody Consultant c) {
        return ResponseEntity.ok(consultantService.searchConsultantsByNom(c.getNom()));
    }

    @PostMapping("/search/firstname")
    public ResponseEntity<List<Consultant>> searchByFirstName(@RequestBody Consultant c) {
        return ResponseEntity.ok(consultantService.searchConsultantsByPrenom(c.getPrenom()));
    }

    @PostMapping("/search/email")
    public ResponseEntity<List<Consultant>> searchByEmail(@RequestBody Consultant c) {
        return ResponseEntity.ok(consultantService.searchConsultantsByEmail(c.getEmail()));
    }

    @PostMapping("/search/competences")
    public ResponseEntity<List<Consultant>> searchByCompetences(@RequestBody Consultant c) {
        List<Consultant> consultants = new ArrayList<>();
        for(int i = 0; i < c.getCompetences().size(); i++) {
            for(Consultant consult : consultantService.searchAllConsultants()) {
                for(Competence consultCompet : consult.getCompetences()) {
                    if (Objects.equals(consultCompet.getNom(), c.getCompetences().get(i).getNom())) {
                        consultants.add(consult);
                    }
                }
            }
        }

        return ResponseEntity.ok(consultants);
    }

    @PostMapping("/search/tjm")
    public ResponseEntity<List<Consultant>> searchByTarifJournalier(@RequestBody Consultant c) {
        return ResponseEntity.ok(consultantService.searchConsultantsByTarifJournalier(c.getTarifJournalier()));
    }

    @PostMapping("/search/disponibility")
    public ResponseEntity<List<Consultant>> searchByDisponibilite(@RequestBody Consultant c) {
        return ResponseEntity.ok(consultantService.searchConsultantsByDisponibility(c.getDisponibilite()));
    }

    @PostMapping("/search/modality")
    public ResponseEntity<List<Consultant>> searchByPaymentModality(@RequestBody Consultant c) {
        return ResponseEntity.ok(consultantService.searchConsultantsByPaymentModality(c.getModalitesPaiement()));
    }
}