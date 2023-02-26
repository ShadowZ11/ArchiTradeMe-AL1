package archi.tread.me.grp13.infrastructure.rest;

import archi.tread.me.grp13.application.service.OffreServiceImpl;
import archi.tread.me.grp13.domain.consultant.model.Consultant;
import archi.tread.me.grp13.domain.offre.model.Offre;
import archi.tread.me.grp13.domain.offre.service.OffreService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/offres")
public class OffreController {

    private final OffreService offreService = new OffreServiceImpl();


    @PostMapping("/createOffer")
    public ResponseEntity<Offre> createOffer(@RequestBody Offre offre) {
        return ResponseEntity.ok(offreService.createOffre(offre));
    }

    @GetMapping("/getOffer")
    public ResponseEntity<Offre> getOffer(@PathVariable Long id) {
        return ResponseEntity.ok(offreService.getOffre(id));
    }

    @GetMapping("/getOffers")
    public ResponseEntity<List<Offre>> getOffers() {
        return ResponseEntity.ok(offreService.getAllOffre());
    }

    @PutMapping("/updateOffer")
    public ResponseEntity<Offre> updateOffer(@PathVariable Long id, @RequestBody Offre offre) {
        Offre updatedConsultant = offreService.updateOffre(id, offre);
        return ResponseEntity.ok(updatedConsultant);
    }
}
