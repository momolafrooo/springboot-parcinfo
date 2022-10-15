package sn.isi.parcinfo.service;

import sn.isi.parcinfo.dto.RoleDto;

import java.util.List;

public interface IRoleService {

    RoleDto create(RoleDto roleDto);
    RoleDto update(int id, RoleDto roleDto);
    void remove(int id);
    RoleDto get(int id);
    List<RoleDto> getAll();
}
