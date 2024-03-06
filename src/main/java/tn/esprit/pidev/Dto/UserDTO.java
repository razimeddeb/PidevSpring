package tn.esprit.pidev.Dto;


import tn.esprit.pidev.entity.Role;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class UserDTO {
    private Long idUser;
    private String userName;
    private String address;
    private String mail;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public UserDTO(Long idUser, String userName, String address, String mail, String password, Role role) {
        this.idUser = idUser;
        this.userName = userName;
        this.address = address;
        this.mail = mail;
        this.password = password;
        this.role = role;
    }

    public UserDTO() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}