package sn.isi.parcinfo.service;

import sn.isi.parcinfo.dto.RoleDto;
import sn.isi.parcinfo.dto.ServeurDto;

import java.util.List;

public interface IServeurService {

    public ServeurDto create(ServeurDto serveurDto);
    public ServeurDto update(ServeurDto serveurDto);
    public void remove(int id);
    public ServeurDto get(int id);
    public List<ServeurDto> getAll();
}
