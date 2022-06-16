package uz.shoxvlogs.shoxvlogs.intity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fayl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nom;

    private LocalDate localDate;

    public Fayl() {
    }

    public Fayl(Long id, String nom, LocalDate localDate) {
        this.id = id;
        this.nom = nom;
        this.localDate = localDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}