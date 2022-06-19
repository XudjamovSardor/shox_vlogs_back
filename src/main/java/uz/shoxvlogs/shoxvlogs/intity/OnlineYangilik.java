package uz.shoxvlogs.shoxvlogs.intity;

import javax.persistence.*;

@Entity
public class OnlineYangilik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String caption;

    private String link;

    private Boolean boshSahifaga;

    private String tur;

    public OnlineYangilik() {}

    public OnlineYangilik(Long id, String caption, String link, Boolean boshSahifaga, String tur) {
        this.id = id;
        this.caption = caption;
        this.link = link;
        this.boshSahifaga = boshSahifaga;
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
        return boshSahifaga;
    }

    public void setBoshSahifaga(Boolean boshSahifaga) {
        this.boshSahifaga = boshSahifaga;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }
}
