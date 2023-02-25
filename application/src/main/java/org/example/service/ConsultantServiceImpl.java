package org.example.service;

import org.example.consultant.model.Competence;
import org.example.consultant.model.Consultant;
import org.example.consultant.repository.ConsultantRepository;
import org.example.consultant.service.ConsultantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
public class ConsultantServiceImpl implements ConsultantService {

    @Autowired
    private ConsultantRepository consultantRepository;

    @Override
    public Consultant registerConsultant(Consultant consultant) {
        // Ajouter la logique pour la validation des données du consultant
        return consultantRepository.save(consultant);
    }

    @Override
    public Consultant updateConsultant(Long id, Consultant consultant) {
        Consultant existingConsultant = consultantRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Consultant not found"));
        // Ajouter la logique pour la validation des données du consultant
        existingConsultant.setNom(consultant.getNom());
        existingConsultant.setPrenom(consultant.getPrenom());
        existingConsultant.setEmail(consultant.getEmail());
        existingConsultant.setCompetences(consultant.getCompetences());
        existingConsultant.setTarifJournalier(consultant.getTarifJournalier());
        existingConsultant.setDisponibilite(consultant.getDisponibilite());
        existingConsultant.setModalitesPaiement(consultant.getModalitesPaiement());
        return consultantRepository.save(existingConsultant);
    }

    @Override
    public List<Consultant> searchConsultants(List<Competence> competences, LocalDate disponibilite) {
        // Ajouter la logique pour la recherche de consultants
        return consultantRepository.findByCompetencesInAndDisponibiliteGreaterThanEqual(competences, disponibilite);
    }
}