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
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 150, unique = true)
    private String nom;

    @ManyToMany(mappedBy = "roles")
    private List<Ingenieur> ingenieurs = new ArrayList<>();
}
