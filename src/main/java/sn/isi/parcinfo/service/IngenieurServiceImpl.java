package sn.isi.parcinfo.service;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.parcinfo.dto.IngenieurDto;
import sn.isi.parcinfo.exception.EntityNotFoundException;
import sn.isi.parcinfo.exception.RequestException;
import sn.isi.parcinfo.mapper.IngenieurMapper;
import sn.isi.parcinfo.repository.IngenieurRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class IngenieurServiceImpl implements IIngenieurService{

    private IngenieurMapper ingenieurMapper;
    private IngenieurRepository ingenieurRepository;
    private MessageSource messageSource;

    @Transactional
    @Override
    public IngenieurDto create(IngenieurDto ingenieurDto) {
        ingenieurRepository.findByEmail(ingenieurDto.getEmail())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("ingenieur.exists", new Object[]{ingenieurDto.getId()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        return ingenieurMapper.fromIngenieur(ingenieurRepository.save(ingenieurMapper.toIngenieur(ingenieurDto)));
    }

    @Transactional
    @Override
    public IngenieurDto update(int id, IngenieurDto ingenieurDto) {

        return ingenieurRepository.findById(id)
                .map(entity -> {
                    ingenieurDto.setId(id);
                    return ingenieurMapper.fromIngenieur(
                            ingenieurRepository.save(ingenieurMapper.toIngenieur(ingenieurDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("ingenieur.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    @Override
    public void remove(int id) {
        try {
            ingenieurRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("ingenieur.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public IngenieurDto get(int id) {
        return ingenieurMapper.fromIngenieur(ingenieurRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("ingenieur.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional(readOnly = true)
    @Override
    public List<IngenieurDto> getAll() {
        return StreamSupport.stream(ingenieurRepository.findAll().spliterator(), false)
                .map(ingenieurMapper::fromIngenieur)
                .collect(Collectors.toList());
    }
}
