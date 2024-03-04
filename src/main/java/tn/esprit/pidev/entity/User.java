package tn.esprit.pidev.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

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
    @JsonIgnore
    @ManyToMany
    List<CallForTender>callForTendersORG;

/*    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy="participants")
    List<Interview>interviews;*/

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    List<Offer> offers;

    @JsonIgnore
    @ManyToMany
    List<Review>reviews;



}
