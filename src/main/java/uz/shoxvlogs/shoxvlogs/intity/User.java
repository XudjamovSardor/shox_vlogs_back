package uz.shoxvlogs.shoxvlogs.intity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "system_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 30, min = 3)
    @Column(length = 30, nullable = false)
    private String ism;

    @Column(length = 30)
    private String familiya;

    @NotNull
    @Size(min = 6, max = 10)
    @Column(length = 10, nullable = false, unique = true)
    private String login;

    @NotNull
    @Size(min = 6, max = 10)
    @Column(length = 10, nullable = false, unique = true)
    private String parol;

    private Boolean aktiv = false;

    private LocalDateTime regTime;
    private LocalDateTime updateTime;

    @ElementCollection(targetClass = Lavozim.class, fetch = FetchType.EAGER)
    @CollectionTable
    @JoinTable(name = "user_lavozimlar", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "lavozim", nullable = false)
    private Set<Lavozim> lavozimlar;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsm() {
        return ism;
    }

    public void setIsm(String ism) {
        this.ism = ism;
    }

    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getParol() {
        return parol;
    }

    public void setParol(String parol) {
        this.parol = parol;
    }

    public Boolean getAktiv() {
        return aktiv;
    }

    public void setAktiv(Boolean aktiv) {
        this.aktiv = aktiv;
    }

    public LocalDateTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDateTime regTime) {
        this.regTime = regTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Set<Lavozim> getLavozimlar() {
        return lavozimlar;
    }

    public void setLavozimlar(Set<Lavozim> lavozimlar) {
        this.lavozimlar = lavozimlar;
    }
}

