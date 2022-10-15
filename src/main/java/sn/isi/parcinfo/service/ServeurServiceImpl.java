package sn.isi.parcinfo.service;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.parcinfo.dto.ServeurDto;
import sn.isi.parcinfo.exception.EntityNotFoundException;
import sn.isi.parcinfo.exception.RequestException;
import sn.isi.parcinfo.mapper.ServeurMapper;
import sn.isi.parcinfo.repository.ServeurRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ServeurServiceImpl implements IServeurService {

    private MessageSource messageSource;
    private ServeurRepository serveurRepository;
    private ServeurMapper serveurMapper;

    @Transactional
    @Override
    public ServeurDto create(ServeurDto serveurDto) {
        serveurRepository.findByNom(serveurDto.getNom())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("serveur.exists", new Object[]{serveurDto.getId()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        return serveurMapper.fromServeur(serveurRepository.save(serveurMapper.toServeur(serveurDto)));
    }

    @Transactional
    @Override
    public ServeurDto update(int id, ServeurDto serveurDto) {
        return serveurRepository.findById(id)
                .map(entity -> {
                    serveurDto.setId(id);
                    return serveurMapper.fromServeur(
                            serveurRepository.save(serveurMapper.toServeur(serveurDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("serveur.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    @Override
    public void remove(int id) {
        try {
            serveurRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("serveur.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ServeurDto get(int id) {
        return serveurMapper.fromServeur(serveurRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("serveur.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ServeurDto> getAll() {
        return serveurRepository.findAll().stream()
                .map(serveurMapper::fromServeur)
                .collect(Collectors.toList());
    }
}
