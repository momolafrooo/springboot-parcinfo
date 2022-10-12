package sn.isi.parcinfo.mapper;

import org.mapstruct.Mapper;
import sn.isi.parcinfo.dto.IngenieurDto;
import sn.isi.parcinfo.dto.RoleDto;
import sn.isi.parcinfo.entities.Ingenieur;
import sn.isi.parcinfo.entities.Role;

@Mapper
public interface RoleMapper
{
    Role toRole(RoleDto roleDto);
    RoleDto fromRole(Role role);
}
