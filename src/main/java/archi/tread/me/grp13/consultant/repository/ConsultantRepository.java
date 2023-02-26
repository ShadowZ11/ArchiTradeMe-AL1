package archi.tread.me.grp13.consultant.repository;

import archi.tread.me.grp13.consultant.model.Competence;
import archi.tread.me.grp13.consultant.model.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ConsultantRepository extends JpaRepository<Consultant, Long> {
    //List<Consultant> findByCompetencesInAndDisponibiliteGreaterThanEqual(Competence competences, LocalDate disponibilite);
}
