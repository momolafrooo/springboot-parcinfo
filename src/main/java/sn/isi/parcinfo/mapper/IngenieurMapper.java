package sn.isi.parcinfo.mapper;


import org.mapstruct.Mapper;
import sn.isi.parcinfo.dto.IngenieurDto;
import sn.isi.parcinfo.entities.Ingenieur;

@Mapper
public interface IngenieurMapper {

    Ingenieur toIngenieur(IngenieurDto ingenieurDto);
    IngenieurDto fromIngenieur(Ingenieur ingenieur);
}
