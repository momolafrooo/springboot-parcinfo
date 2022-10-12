package sn.isi.parcinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceDto {

    private int id;

    @NotNull(message = "Le port est obligatoire")
    private int port;
}
