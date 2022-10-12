package sn.isi.parcinfo.mapper;

import org.mapstruct.Mapper;
import sn.isi.parcinfo.dto.RoleDto;
import sn.isi.parcinfo.dto.ServeurDto;
import sn.isi.parcinfo.entities.Role;
import sn.isi.parcinfo.entities.Serveur;

@Mapper
public interface ServeurMapper {

    Serveur toServeur(ServeurDto serveurDto);
    ServeurDto fromServeur(Serveur serveur);
}
