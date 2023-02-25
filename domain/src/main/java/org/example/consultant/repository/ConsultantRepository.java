package org.example.consultant.repository;

import org.example.consultant.model.Competence;
import org.example.consultant.model.Consultant;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ConsultantRepository {
    public Consultant save(Consultant consultant) {
        return Consultant.builder().build();
    }

    public Optional<Consultant> findById(Long id) {
        return Optional.empty();
    }

    public List<Consultant> findByCompetencesInAndDisponibiliteGreaterThanEqual(List<Competence> competences, LocalDate disponibilite) {

        return List.of(Consultant.builder().build());

    }
}
