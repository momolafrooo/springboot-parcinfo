package sn.isi.parcinfo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingenieur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 150)
    private String nom;

    @Column(nullable = false, length = 200)
    private String prenom;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Column(nullable = false, length = 150)
    private String password;

    @Column(nullable = false)
    private int etat;

    @ManyToMany
    private List<Role> roles = new ArrayList<>();
}
