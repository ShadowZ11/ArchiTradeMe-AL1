package org.example.consultant.service;

import org.example.consultant.model.Competence;
import org.example.consultant.model.Consultant;

import java.time.LocalDate;
import java.util.List;

public interface ConsultantService {
    Consultant registerConsultant(Consultant consultant);

    Consultant updateConsultant(Long id, Consultant consultant);

    List<Consultant> searchConsultants(Competence competences, LocalDate disponibilite);
}
