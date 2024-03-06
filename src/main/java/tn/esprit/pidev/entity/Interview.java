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
public class Interview implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idInterview;
    LocalDate dateInterview;
    String classRoom;
    String interviewer;
    String cv;
    int requestStatus;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "offer_id")
    private Offer offer;

}
