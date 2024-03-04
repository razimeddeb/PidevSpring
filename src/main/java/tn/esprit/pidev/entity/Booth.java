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
public class Booth implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBooth;
    @Enumerated(EnumType.STRING)
    StatusBooth statusBooth;
    String description;
    @JsonIgnore
    @ManyToOne
    Pack pack;
    @OneToOne
    User company;

}
