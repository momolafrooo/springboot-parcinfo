package sn.isi.parcinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.isi.parcinfo.entities.Ingenieur;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServeurDto {

    private int id;

    @NotNull(message = "Le nom est obligatoire")
    private String nom;

    @NotNull(message = "L'adresse ip est obligatoire")
    private String adrip;
}
