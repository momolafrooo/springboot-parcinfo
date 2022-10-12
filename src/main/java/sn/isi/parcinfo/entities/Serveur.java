package sn.isi.parcinfo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Serveur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(nullable = false, length = 150, unique = true)
    private String nom;

    @Column(nullable = false, length = 150, unique = true)
    private String adrip;

    @ManyToOne
    private Ingenieur ingenieur;
}
