package archi.tread.me.grp13.domain.consultant.service;

import archi.tread.me.grp13.domain.consultant.model.Consultant;

public interface ConsultantService {
    Consultant registerConsultant(Consultant consultant);

    Consultant updateConsultant(Long id, Consultant consultant);

    //List<Consultant> searchConsultants(Competence competences, LocalDate disponibilite);
}
