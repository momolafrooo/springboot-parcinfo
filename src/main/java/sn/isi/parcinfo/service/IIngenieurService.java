package sn.isi.parcinfo.service;

import sn.isi.parcinfo.dto.IngenieurDto;
import sn.isi.parcinfo.entities.Ingenieur;

import java.util.List;

public interface IIngenieurService {

    public IngenieurDto create(IngenieurDto ingenieurDto);
    public IngenieurDto update(int id, IngenieurDto ingenieurDto);
    public void remove(int id);
    public IngenieurDto get(int id);
    public List<IngenieurDto> getAll();
}
