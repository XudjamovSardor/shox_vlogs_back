package uz.shoxvlogs.shoxvlogs.intity;

import javax.persistence.*;

@Entity
public class OnlineYangilik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caption;

    private String link;

    private Boolean BoshSahifaga;

    private Tur tur;

    public OnlineYangilik() {}

    public OnlineYangilik(Long id, String caption, String link, Boolean boshSahifaga, Tur tur) {
        this.id = id;
        this.caption = caption;
        this.link = link;
        BoshSahifaga = boshSahifaga;
        this.tur = tur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getBoshSahifaga() {
        return BoshSahifaga;
    }

    public void setBoshSahifaga(Boolean boshSahifaga) {
        BoshSahifaga = boshSahifaga;
    }

    public Tur getTur() {
        return tur;
    }

    public void setTur(Tur tur) {
        this.tur = tur;
    }
}
