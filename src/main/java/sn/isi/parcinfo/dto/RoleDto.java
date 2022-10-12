package sn.isi.parcinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.isi.parcinfo.entities.Ingenieur;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDto {

    private int id;

    @NotNull(message = "le nom est obligatoire")
    private String nom;

}
