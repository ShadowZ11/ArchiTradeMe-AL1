package archi.tread.me.grp8.domain.consultant.repository;

import archi.tread.me.grp8.domain.consultant.model.Competence;
import archi.tread.me.grp8.domain.consultant.model.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsultantRepository extends JpaRepository<Consultant, Long> {

    List<Consultant> findByDisponibiliteGreaterThanEqual(LocalDate disponibilite);
    List<Consultant> findByNom(String nom);
    List<Consultant> findByPrenom(String prenom);
    List<Consultant> findByEmail(String email);
    List<Consultant> findByTarifJournalier(Long TarifJournalier);
    List<Consultant> findByModalitesPaiement(String modalitesPaiement);
    List<Consultant> findByCompetences(Competence competences);
}
