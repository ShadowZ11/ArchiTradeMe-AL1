package archi.tread.me.grp13.domain.offre.exception;

public class OffreNotFoundException extends RuntimeException{

    public OffreNotFoundException(Long id) {
        super("Offre not found with id : " + id);
    }

}
