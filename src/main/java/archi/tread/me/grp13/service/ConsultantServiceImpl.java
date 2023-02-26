package archi.tread.me.grp13.service;

import archi.tread.me.grp13.ModalitePaiement;
import archi.tread.me.grp13.consultant.model.Competence;
import archi.tread.me.grp13.consultant.model.Consultant;
import archi.tread.me.grp13.consultant.repository.ConsultantRepository;
import archi.tread.me.grp13.consultant.service.ConsultantService;
import jakarta.persistence.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;

public class ConsultantServiceImpl implements ConsultantService {

    private ConsultantRepository consultantRepository;

    @Override
    public Consultant registerConsultant(Consultant consultant) {
        // Ajouter la logique pour la validation des données du consultant
        if( consultant.getNom()==""||consultant.getPrenom()==""||!consultant.getEmail().contains("@")||consultant.getCompetencesList().size()==0||consultant.getTarifJournalier()<0||consultant.getDisponibilite()==null){
            return null;
        }else{
            for (ModalitePaiement modalite : ModalitePaiement.values()) {
                if (modalite.name().equals(consultant.getModalitesPaiement().toString())) {
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

    /*@Override
    public List<Consultant> searchConsultants(Competence competences, LocalDate disponibilite) {
        // Ajouter la logique pour la recherche de consultants
        return consultantRepository.findByCompetencesInAndDisponibiliteGreaterThanEqual(competences, disponibilite);
    }*/
}