package sn.isi.parcinfo.mapper;

import org.mapstruct.Mapper;
import sn.isi.parcinfo.dto.ServeurDto;
import sn.isi.parcinfo.dto.ServiceDto;
import sn.isi.parcinfo.entities.Serveur;
import sn.isi.parcinfo.entities.Service;

@Mapper
public interface ServiceMapper {
    Service toService(ServiceDto serviceDto);
    ServiceDto fromService(Service service);
}
