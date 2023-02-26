package archi.tread.me.grp13.domain.offre.service;

import archi.tread.me.grp13.domain.offre.model.Offre;

import java.util.List;

public interface OffreService {

    Offre createOffre(Offre offre);

    Offre getOffre(Long id);

    Offre updateOffre(Long id, Offre offre);

    List<Offre> getAllOffre();

}
