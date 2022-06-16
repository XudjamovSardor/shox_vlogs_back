package uz.shoxvlogs.shoxvlogs.intity;

import javax.persistence.*;

@Entity
public class Reklama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Fayl image;

    private Boolean baner;

    public Reklama() {}

    public Reklama(Long id, Fayl image, Boolean baner) {
        this.id = id;
        this.image = image;
        this.baner = baner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fayl getImage() {
        return image;
    }

    public void setImage(Fayl image) {
        this.image = image;
    }

    public Boolean getBaner() {
        return baner;
    }

    public void setBaner(Boolean baner) {
        this.baner = baner;
    }
}
