package sn.isi.parcinfo.service;

import sn.isi.parcinfo.dto.ServeurDto;
import sn.isi.parcinfo.dto.ServiceDto;

import java.util.List;

public interface IServiceService {

    public ServiceDto create(ServiceDto serviceDto);
    public ServiceDto update(ServiceDto serviceDto);
    public void remove(int id);
    public ServiceDto get(int id);
    public List<ServiceDto> getAll();
}
