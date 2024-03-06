package tn.esprit.pidev.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
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
    String domain;
    @Enumerated(EnumType.STRING)
    TypeOffer typeOffer;

    @JsonIgnore
    @OneToMany( mappedBy="offer")
    private List<Interview>interviews;


    @ManyToMany( mappedBy="offers")
    @JsonIgnore
    private List<User> users = new ArrayList<>();




}
