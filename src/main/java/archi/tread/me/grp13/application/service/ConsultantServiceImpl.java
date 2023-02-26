package archi.tread.me.grp13.application.service;

import archi.tread.me.grp13.domain.ModalitePaiement;
import archi.tread.me.grp13.domain.consultant.model.Competence;
import archi.tread.me.grp13.domain.consultant.model.Consultant;
import archi.tread.me.grp13.domain.consultant.repository.CompetenceRepository;
import archi.tread.me.grp13.domain.consultant.repository.ConsultantRepository;
import archi.tread.me.grp13.domain.consultant.service.ConsultantService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class ConsultantServiceImpl implements ConsultantService {

    @Autowired
    private final ConsultantRepository consultantRepository;

    @Autowired
    private final CompetenceRepository competenceRepository;

    @Override
    public Consultant registerConsultant(Consultant consultant) {
        // Ajouter la logique pour la validation des données du consultant
        if(Objects.equals(consultant.getNom(), "") || Objects.equals(consultant.getPrenom(), "") ||!consultant.getEmail().contains("@")||consultant.getCompetencesList().size()==0||consultant.getTarifJournalier()<0||consultant.getDisponibilite()==null){
            System.out.println(consultant.getCompetencesList());
            System.out.println(Objects.equals(consultant.getNom(), ""));
            System.out.println(Objects.equals(consultant.getPrenom(), ""));
            System.out.println(!consultant.getEmail().contains("@"));
            System.out.println(consultant.getCompetencesList().size());
            System.out.println(consultant.getTarifJournalier()<0);
            System.out.println(consultant.getDisponibilite()==null);

            return null;
        }else{
            for (ModalitePaiement modalite : ModalitePaiement.values()) {
                if (modalite.name().equals(consultant.getModalitesPaiement().toString().toUpperCase())) {
                    competenceRepository.saveAll(consultant.getCompetences());
                    return consultantRepository.save(consultant);
                }
            }
        }
        return  null;
    }

    @Override
    public Consultant updateConsultant(Long id, Consultant consultant) {
        Consultant existingConsultant = consultantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Consultant not found"));
        // Ajouter la logique pour la validation des données du consultant
        if(consultant.getNom()!=existingConsultant.getNom()&&consultant.getNom()!="") existingConsultant.setNom(consultant.getNom());
        if(consultant.getPrenom()!=existingConsultant.getPrenom()&&consultant.getPrenom()!="") existingConsultant.setPrenom(consultant.getPrenom());
        if(consultant.getEmail()!=existingConsultant.getEmail()&&consultant.getEmail().contains("@")) existingConsultant.setEmail(consultant.getEmail());
        if(consultant.getCompetencesList()!=existingConsultant.getCompetencesList()&&consultant.getCompetencesList().size()!=0) existingConsultant.setCompetencesList(consultant.getCompetencesList());
        if(consultant.getTarifJournalier()!=existingConsultant.getTarifJournalier()&&consultant.getTarifJournalier()>=0) existingConsultant.setTarifJournalier(consultant.getTarifJournalier());
        if(consultant.getDisponibilite()!=existingConsultant.getDisponibilite()&&consultant.getDisponibilite()!=null) existingConsultant.setDisponibilite(consultant.getDisponibilite());
        for (ModalitePaiement modalite : ModalitePaiement.values()) {
            if (modalite.name().equals(consultant.getModalitesPaiement().toString())) {
                if(consultant.getModalitesPaiement()!=existingConsultant.getModalitesPaiement()) existingConsultant.setModalitesPaiement(consultant.getModalitesPaiement());
            }
        }
        return consultantRepository.save(existingConsultant);
    }

    @Override
    public List<Consultant> searchAllConsultants() {
        // Ajouter la logique pour la recherche de consultants
        return consultantRepository.findAll();
    }
    @Override
    public List<Consultant> searchConsultantsByCompetence(Competence competences) {
        // Ajouter la logique pour la recherche de consultants
        return consultantRepository.findByCompetences(competences);
    }
    @Override
    public List<Consultant> searchConsultantsByDisponibility(LocalDate disponibilite) {
        // Ajouter la logique pour la recherche de consultants
        return consultantRepository.findByDisponibiliteGreaterThanEqual(disponibilite);
    }
    @Override
    public List<Consultant> searchConsultantsByNom(String nom) {
        // Ajouter la logique pour la recherche de consultants
        return consultantRepository.findByNom(nom);
    }
    @Override
    public List<Consultant> searchConsultantsByPrenom(String prenom) {
        // Ajouter la logique pour la recherche de consultants
        return consultantRepository.findByPrenom(prenom);
    }
    @Override
    public List<Consultant> searchConsultantsByEmail(String email) {
        // Ajouter la logique pour la recherche de consultants
        return consultantRepository.findByEmail(email);
    }
    @Override
    public List<Consultant> searchConsultantsByTarifJournalier(Long TarifJournalier) {
        // Ajouter la logique pour la recherche de consultants
        return consultantRepository.findByTarifJournalier(TarifJournalier);
    }
    @Override
    public List<Consultant> searchConsultantsByPaymentModality(ModalitePaiement modalitesPaiement) {
        // Ajouter la logique pour la recherche de consultants
        return consultantRepository.findByModalitesPaiement(modalitesPaiement);
    }

    @Override
    public List<Consultant> searchConsultantsByCompetenceList(List<Competence> competencesList) {
        List<Consultant> res=new ArrayList<Consultant>();
        List<Consultant> tmp=new ArrayList<Consultant>();
        for (int x=0;x<competencesList.size();x++) {
            if(x==0){
                for (Consultant y : searchConsultantsByCompetence(competencesList.get(x))){
                    if (!res.contains(y)){
                        res.add(y);
                    }
                }

            }else{
                for (Consultant y : searchConsultantsByCompetence(competencesList.get(x))){
                    if (res.contains(y)){
                        tmp.add(y);
                    }
                }
                res= new ArrayList<Consultant>(tmp);
            }
            tmp=new ArrayList<Consultant>();
        }
        return res;
    }
}