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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUser;
    String userName;
    String address;
    String mail ;
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
        this.mail = mail;
        this.password = password;
        this.role = role;
        // Set other fields as needed
    }


}
