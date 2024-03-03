package tn.esprit.pidev.entity;

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
    @ManyToMany(cascade = CascadeType.ALL, mappedBy="offersP")
    List<User>participents;
    @ManyToOne
    User company;


}
