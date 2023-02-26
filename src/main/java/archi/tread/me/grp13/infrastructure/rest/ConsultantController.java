package archi.tread.me.grp13.infrastructure.rest;

import archi.tread.me.grp13.domain.consultant.model.Consultant;
import archi.tread.me.grp13.domain.consultant.repository.ConsultantRepository;
import archi.tread.me.grp13.domain.consultant.service.ConsultantService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultants")
public class ConsultantController {

    private ConsultantRepository consultantRepository;

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

    /*@GetMapping("/search/{competence}")
    public ResponseEntity<List<Consultant>> searchConsultants(@RequestParam("competences") Competence competences,
                                                              @RequestParam("disponibilite") LocalDate disponibilite) {
        List<Consultant> consultants = consultantService.searchConsultants(competences, disponibilite);
        return ResponseEntity.ok(consultants);
    }*/
}