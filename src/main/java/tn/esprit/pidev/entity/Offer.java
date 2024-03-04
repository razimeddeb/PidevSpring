package tn.esprit.pidev.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Offer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idOffer;
    String name;
    String description;
    LocalDate dateOffer;
    String Domain;
    @Enumerated(EnumType.STRING)
    TypeOffer typeOffer;

/*    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="offer")
    List<Interview>interviews;*/

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy="offers")
    List<User> users;




}
