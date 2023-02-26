package archi.tread.me.grp13.application.service;

import archi.tread.me.grp13.domain.offre.exception.OffreNotFoundException;
import archi.tread.me.grp13.domain.offre.model.Offre;
import archi.tread.me.grp13.domain.offre.repository.OffreRepository;
import archi.tread.me.grp13.domain.offre.service.OffreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class OffreServiceImpl implements OffreService {

    private OffreRepository offreRepository;

    @Override
    public Offre createOffre(Offre offre) {
        return offreRepository.save(offre);
    }

    @Override
    public Offre getOffre(Long id) {
        return offreRepository.findById(id).orElseThrow(() -> new OffreNotFoundException(id));
    }

    @Override
    public Offre updateOffre(Long id, Offre offre) {
        return offreRepository.save(offre);
    }

    @Override
    public List<Offre> getAllOffre() {
        return offreRepository.findAll();
    }
}
