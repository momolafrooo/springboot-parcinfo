package sn.isi.parcinfo.service;

import sn.isi.parcinfo.dto.IngenieurDto;
import sn.isi.parcinfo.dto.RoleDto;

import java.util.List;

public interface IRoleService {

    public RoleDto create(RoleDto roleDto);
    public RoleDto update(RoleDto roleDto);
    public void remove(int id);
    public RoleDto get(int id);
    public List<RoleDto> getAll();
}
