package sn.isi.parcinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.isi.parcinfo.entities.Role;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngenieurDto {

    private int id;

    @NotNull(message = "Le nom est obligatoire")
    private String nom;

    @NotNull(message = "Le prenom est obligatoire")
    private String prenom;

    @NotNull(message = "L'email est obligatoire")
    private String email;

    @NotNull(message = "Le mot de passe est obligatoire")
    private String password;

    @NotNull(message = "L'etat est obligatoire")
    private int etat;

}
