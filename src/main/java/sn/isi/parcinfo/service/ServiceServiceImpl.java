package sn.isi.parcinfo.service;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.parcinfo.dto.ServiceDto;
import sn.isi.parcinfo.exception.EntityNotFoundException;
import sn.isi.parcinfo.exception.RequestException;
import sn.isi.parcinfo.mapper.ServiceMapper;
import sn.isi.parcinfo.repository.ServiceRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ServiceServiceImpl implements IServiceService {

    private MessageSource messageSource;
    private ServiceMapper serviceMapper;
    private ServiceRepository serviceRepository;

    @Transactional
    @Override
    public ServiceDto create(ServiceDto serviceDto) {
        serviceRepository.findByPort(serviceDto.getPort())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("service.exists", new Object[]{serviceDto.getId()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        return serviceMapper.fromService(serviceRepository.save(serviceMapper.toService(serviceDto)));
    }

    @Transactional
    @Override
    public ServiceDto update(int id, ServiceDto serviceDto) {
        return serviceRepository.findById(id)
                .map(entity -> {
                    serviceDto.setId(id);
                    return serviceMapper.fromService(
                            serviceRepository.save(serviceMapper.toService(serviceDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("service.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    @Override
    public void remove(int id) {
        try {
            serviceRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("service.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ServiceDto get(int id) {
        return serviceMapper.fromService(serviceRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("service.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ServiceDto> getAll() {
        return serviceRepository.findAll().stream()
                .map(serviceMapper::fromService)
                .collect(Collectors.toList());
    }
}
