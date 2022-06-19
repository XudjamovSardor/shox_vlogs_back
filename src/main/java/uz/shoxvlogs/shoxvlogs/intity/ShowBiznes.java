package uz.shoxvlogs.shoxvlogs.intity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class ShowBiznes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matn;

    @ManyToOne
    private Fayl image;

    @Column(columnDefinition="TEXT")
    private String tuliqMalumot;

    private LocalDate date;

    public ShowBiznes() {}

    public ShowBiznes(Long id, String matn, Fayl image, String tuliqMalumot, LocalDate date) {
        this.id = id;
        this.matn = matn;
        this.image = image;
        this.tuliqMalumot = tuliqMalumot;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatn() {
        return matn;
    }

    public void setMatn(String matn) {
        this.matn = matn;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate dateTime) {
        this.date = dateTime;
    }
}