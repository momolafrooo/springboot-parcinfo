package sn.isi.parcinfo.service;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.parcinfo.dto.RoleDto;
import sn.isi.parcinfo.exception.EntityNotFoundException;
import sn.isi.parcinfo.exception.RequestException;
import sn.isi.parcinfo.mapper.RoleMapper;
import sn.isi.parcinfo.repository.RoleRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements IRoleService {

    private RoleMapper roleMapper;
    private RoleRepository roleRepository;
    private MessageSource messageSource;

    @Transactional
    @Override
    public RoleDto create(RoleDto roleDto) {
        roleRepository.findByNom(roleDto.getNom())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("role.exists", new Object[]{roleDto.getId()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        return roleMapper.fromRole(roleRepository.save(roleMapper.toRole(roleDto)));
    }

    @Transactional
    @Override
    public RoleDto update(int id, RoleDto roleDto) {
        return roleRepository.findById(id)
                .map(entity -> {
                    roleDto.setId(id);
                    return roleMapper.fromRole(
                            roleRepository.save(roleMapper.toRole(roleDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    @Override
    public void remove(int id) {
        try {
            roleRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("role.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public RoleDto get(int id) {
        return roleMapper.fromRole(roleRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Transactional(readOnly = true)
    @Override
    public List<RoleDto> getAll() {
        return roleRepository.findAll().stream()
                .map(roleMapper::fromRole)
                .collect(Collectors.toList());
    }
}
