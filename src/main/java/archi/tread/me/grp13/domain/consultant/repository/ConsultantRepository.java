package archi.tread.me.grp13.domain.consultant.repository;

import archi.tread.me.grp13.domain.consultant.model.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
    //List<Consultant> findByCompetencesInAndDisponibiliteGreaterThanEqual(Competence competences, LocalDate disponibilite);
}
