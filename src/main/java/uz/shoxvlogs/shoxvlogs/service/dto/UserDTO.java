package uz.shoxvlogs.shoxvlogs.service.dto;

import uz.shoxvlogs.shoxvlogs.intity.User;

public class UserDTO {
    private Long id;
    private String ism;
    private String familiya;
    private String login;


    public UserDTO(){}

    public UserDTO(User user){
        this.id = user.getId();
        this.ism = user.getIsm();
        this.familiya = user.getFamiliya();
        this.login = user.getLogin();
    }

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
}
