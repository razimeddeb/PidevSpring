package tn.esprit.pidev.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user")

@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUser;
    String userName;
    String address;
    String email ;
    String password;
    @Enumerated(EnumType.STRING)
    Role role;

    @JsonIgnore
    @ManyToOne
    Pack pack;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    List<Evenement>evenements;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="admin")
    List<Task>tasksAdmin;
    @JsonIgnore
    @ManyToMany
    List<Task>tasksOrgenizer;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="admin")
    List<CallForTender>callForTendersAdmin;
    @ManyToMany
    @JsonIgnore
    List<CallForTender>callForTendersORG;
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy="companys")
    List<Interview>interviews;
    @JsonIgnore
    @ManyToMany
    List<Offer>offersP;
    @JsonIgnore
    @ManyToMany
    List<Review>reviews;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="company")
    List<Offer>offersCompany;

    public User(Long idUser, String userName, String address, String mail, String password, Role role) {
        this.idUser = idUser;
        this.userName = userName;
        this.address = address;
        this.email = mail;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getUserName() {
        return userName;
    }

    public String getAddress() {
        return address;
    }

    public String getMail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMail(String mail) {
        this.email = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", mail='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
