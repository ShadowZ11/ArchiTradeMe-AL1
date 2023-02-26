package archi.tread.me.grp8.domain.consultant.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class ConsultantOptional {
    private Optional<Long> id;

    private Optional<String> nom;

    private Optional<String> prenom;

    private Optional<String> email;

    private Optional<List<Competence>> competences;

    private Optional<Long> tarifJournalier;

    private Optional<LocalDate> disponibilite;

    private Optional<String> modalitesPaiement;

    public Optional<List<Competence>> getCompetences2() {
        return this.competences;
    }

    public void setCompetences(Optional<List<Competence>> competences) {
        this.competences = competences;
    }
}
