package archi.tread.me.grp13.infrastructure.rest;

import archi.tread.me.grp13.application.service.ConsultantServiceImpl;
import archi.tread.me.grp13.domain.consultant.model.Consultant;
import archi.tread.me.grp13.domain.consultant.model.Competence;
import archi.tread.me.grp13.domain.consultant.repository.ConsultantRepository;
import archi.tread.me.grp13.domain.consultant.service.ConsultantService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import archi.tread.me.grp13.domain.ModalitePaiement;

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

    /*@PostMapping("/searchByCompetence")
    public ResponseEntity<List<Consultant>> searchConsultantsByCompetence(@RequestBody Competence competences) {
        List<Consultant> consultants = consultantService.searchConsultantsByCompetence(competences);
        return ResponseEntity.ok(consultants);
    }
    @PostMapping("/searchByDisponibility")
    public ResponseEntity<List<Consultant>> searchConsultantsByDisponibility(@RequestBody LocalDate disponibilite) {
        List<Consultant> consultants = consultantService.searchConsultantsByDisponibility(disponibilite);
        return ResponseEntity.ok(consultants);
    }
    @PostMapping("/searchByCompetenceList")
    public ResponseEntity<List<Consultant>> searchConsultantsByCompetenceList(@RequestBody List<Competence> competencesList){
        List<Consultant> consultants = consultantService.searchConsultantsByCompetenceList(competencesList);
        return ResponseEntity.ok(consultants);
    }*/
    @PostMapping("/search")
    public ResponseEntity<List<Consultant>> searchConsultantsByField(@RequestBody
                                                                             Optional<String> nom,
                                                                     Optional<String> prenom,
                                                                     Optional<String> email,
                                                                     Optional<List<Competence>> competencesList,
                                                                     Optional<Long> TarifJournalier,
                                                                     Optional<LocalDate> disponibilite,
                                                                     Optional<ModalitePaiement> modalitesPaiement
    ){
        List<Consultant> res=new ArrayList<Consultant>();
        List<Consultant> tmp=new ArrayList<Consultant>();
        List<Consultant> tmp2=new ArrayList<Consultant>();
        Boolean isFirst=true;
        if(nom.isPresent()){
            if(nom.get()!=""){
                tmp=consultantService.searchConsultantsByNom(nom.get());
                if(isFirst){
                    res=new ArrayList<Consultant>(tmp);
                    isFirst=false;
                }else{
                    for (Consultant y : tmp){
                        if (res.contains(y)){
                            tmp2.add(y);
                        }
                    }
                    res= new ArrayList<Consultant>(tmp2);
                }
                tmp=new ArrayList<Consultant>();
                tmp2=new ArrayList<Consultant>();
            }
        }

        if(prenom.isPresent()){
            if(prenom.get()!=""){
                tmp=consultantService.searchConsultantsByPrenom(prenom.get());
                if(isFirst){
                    res=new ArrayList<Consultant>(tmp);
                    isFirst=false;
                }else{
                    for (Consultant y : tmp){
                        if (res.contains(y)){
                            tmp2.add(y);
                        }
                    }
                    res= new ArrayList<Consultant>(tmp2);
                }
                tmp=new ArrayList<Consultant>();
                tmp2=new ArrayList<Consultant>();
            }
        }

        if(email.isPresent()){
            if(email.get().contains("@")){
                tmp=consultantService.searchConsultantsByEmail(email.get());
                if(isFirst){
                    res=new ArrayList<Consultant>(tmp);
                    isFirst=false;
                }else{
                    for (Consultant y : tmp){
                        if (res.contains(y)){
                            tmp2.add(y);
                        }
                    }
                    res= new ArrayList<Consultant>(tmp2);
                }
            }
            tmp=new ArrayList<Consultant>();
            tmp2=new ArrayList<Consultant>();
        }

        if(competencesList.isPresent()){
            if(competencesList.get().size()!=0){
                tmp=consultantService.searchConsultantsByCompetenceList(competencesList.get());
                if(isFirst){
                    res=new ArrayList<Consultant>(tmp);
                    isFirst=false;
                }else{
                    for (Consultant y : tmp){
                        if (res.contains(y)){
                            tmp2.add(y);
                        }
                    }
                    res= new ArrayList<Consultant>(tmp2);
                }
            }
            tmp=new ArrayList<Consultant>();
            tmp2=new ArrayList<Consultant>();
        }

        if(TarifJournalier.isPresent()){
            if(TarifJournalier.get()>=0){
                tmp=consultantService.searchConsultantsByTarifJournalier(TarifJournalier.get());
                if(isFirst){
                    res=new ArrayList<Consultant>(tmp);
                    isFirst=false;
                }else{
                    for (Consultant y : tmp){
                        if (res.contains(y)){
                            tmp2.add(y);
                        }
                    }
                    res= new ArrayList<Consultant>(tmp2);
                }
            }
            tmp=new ArrayList<Consultant>();
            tmp2=new ArrayList<Consultant>();
        }
        if(disponibilite.isPresent()){
            if(disponibilite.get()!=null){
                tmp=consultantService.searchConsultantsByDisponibility(disponibilite.get());
                if(isFirst){
                    res=new ArrayList<Consultant>(tmp);
                    isFirst=false;
                }else{
                    for (Consultant y : tmp){
                        if (res.contains(y)){
                            tmp2.add(y);
                        }
                    }
                    res= new ArrayList<Consultant>(tmp2);
                }
            }
            tmp=new ArrayList<Consultant>();
            tmp2=new ArrayList<Consultant>();
        }
        if(modalitesPaiement.isPresent()){
            for (ModalitePaiement modalite : ModalitePaiement.values()) {
                if (modalite.name().equals(modalitesPaiement.get().toString())) {
                    tmp=consultantService.searchConsultantsByPaymentModality(modalitesPaiement.get());
                    if(isFirst){
                        res=new ArrayList<Consultant>(tmp);
                        isFirst=false;
                    }else{
                        for (Consultant y : tmp){
                            if (res.contains(y)){
                                tmp2.add(y);
                            }
                        }
                        res= new ArrayList<Consultant>(tmp2);
                    }
                }
            }
            tmp=new ArrayList<Consultant>();
            tmp2=new ArrayList<Consultant>();
        }
        if(isFirst){
            tmp=consultantService.searchAllConsultants();
            res=new ArrayList<Consultant>(tmp);
        }
        return ResponseEntity.ok(res);
    }
}