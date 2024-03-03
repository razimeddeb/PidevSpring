package tn.esprit.pidev.entity;

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
public class CallForTender implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCOT;
    String description;
    Long quantity;
    String name;
    @ManyToOne
    User admin;
    @ManyToMany(mappedBy="callForTendersORG", cascade = CascadeType.ALL)
    List<User>eventOrgenizers;


}
