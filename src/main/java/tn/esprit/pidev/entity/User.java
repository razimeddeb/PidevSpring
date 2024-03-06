package tn.esprit.pidev.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="user")
@Data
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


    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;



    @JsonIgnore
    @ManyToOne
    Pack pack;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    List<Evenement>evenements;


    @JsonIgnore
    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    private List<Task> tasks;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="admin")
    List<CallForTender>callForTendersAdmin;
    @JsonIgnore
    @ManyToMany
    List<CallForTender>callForTendersORG;

/*    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy="participants")
    List<Interview>interviews;*/

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_offer",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "offer_id"))
    List<Offer> offers;

    @JsonIgnore
    @ManyToMany
    List<Review>reviews;

    public User(Long idUser, String userName, String address, String email, String password, Role role) {
        this.idUser = idUser;
        this.userName = userName;
        this.address = address;
        this.password = password;
        this.role = role;
        this.email = email;
        this.password = password;
        this.role = role;
        // Set other fields as needed
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
