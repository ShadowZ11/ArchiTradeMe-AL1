package archi.tread.me.grp13.domain.consultant.service;

import archi.tread.me.grp13.domain.consultant.model.Consultant;
import archi.tread.me.grp13.domain.consultant.model.Competence;
import archi.tread.me.grp13.domain.ModalitePaiement;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface ConsultantService {
    Consultant registerConsultant(Consultant consultant);
    Consultant updateConsultant(Long id, Consultant consultant);
    List<Consultant> searchConsultantsByNom(String nom);
    List<Consultant> searchConsultantsByPrenom(String prenom);
    List<Consultant> searchConsultantsByEmail(String email);
    List<Consultant> searchConsultantsByCompetence(Competence competences);
    List<Consultant> searchConsultantsByCompetenceList(List<Competence> competencesList);
    List<Consultant> searchConsultantsByTarifJournalier(Long TarifJournalier);
    List<Consultant> searchConsultantsByDisponibility(LocalDate disponibilite);
    List<Consultant> searchConsultantsByPaymentModality(ModalitePaiement modalitesPaiement);
    List<Consultant> searchAllConsultants();
}
