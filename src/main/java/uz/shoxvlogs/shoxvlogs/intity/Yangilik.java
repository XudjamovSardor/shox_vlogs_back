package uz.shoxvlogs.shoxvlogs.intity;

import javax.persistence.*;

@Entity
public class Yangilik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matni;

    @ManyToOne
    private Fayl image;

    @Column(columnDefinition="TEXT")
    private String tuliqMalumot;

    public Yangilik() {}

    public Yangilik(Long id, String matni, Fayl image, String tuliqMalumot) {
        this.id = id;
        this.matni = matni;
        this.image = image;
        this.tuliqMalumot = tuliqMalumot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatni() {
        return matni;
    }

    public void setMatni(String matni) {
        this.matni = matni;
    }

    public Fayl getImage() {
        return image;
    }

    public void setImage(Fayl image) {
        this.image = image;
    }

    public String getTuliqMalumot() {
        return tuliqMalumot;
    }

    public void setTuliqMalumot(String tuliqMalumot) {
        this.tuliqMalumot = tuliqMalumot;
    }
}