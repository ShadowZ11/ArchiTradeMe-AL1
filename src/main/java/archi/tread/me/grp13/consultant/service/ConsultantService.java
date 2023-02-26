package archi.tread.me.grp13.consultant.service;

import archi.tread.me.grp13.consultant.model.Competence;
import archi.tread.me.grp13.consultant.model.Consultant;

import java.time.LocalDate;
import java.util.List;

public interface ConsultantService {
    Consultant registerConsultant(Consultant consultant);

    Consultant updateConsultant(Long id, Consultant consultant);

    //List<Consultant> searchConsultants(Competence competences, LocalDate disponibilite);
}
