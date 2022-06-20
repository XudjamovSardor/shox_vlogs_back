package uz.shoxvlogs.shoxvlogs.intity;

import javax.persistence.*;

@Entity
public class Reklama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Fayl image;

    public Reklama() {}

    public Reklama(Long id, Fayl image) {
        this.id = id;
        this.image = image;
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
}
