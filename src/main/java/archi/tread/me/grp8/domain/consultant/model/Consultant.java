package archi.tread.me.grp8.domain.consultant.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "consultant")
public final class Consultant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "competences")
    private List<Competence> competences;

    @Column(name = "TJM")
    private Long tarifJournalier;

    @Column(name = "dispo")
    private LocalDate disponibilite;

    @Column(name = "modalitesPaiement")
    private String modalitesPaiement;

    public List<Competence> getCompetencesList() {
        return this.competences;
    }

    public void setCompetencesList(List<Competence> competences) {
        this.competences = competences;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", competences=" + competences +
                ", tarifJournalier=" + tarifJournalier +
                ", disponibilite=" + disponibilite +
                ", modalitesPaiement=" + modalitesPaiement +
                '}';
    }
}
