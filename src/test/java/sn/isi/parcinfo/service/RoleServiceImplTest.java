package sn.isi.parcinfo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.isi.parcinfo.dto.IngenieurDto;
import sn.isi.parcinfo.dto.RoleDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoleServiceImplTest {

    @Autowired
    private IRoleService roleService;

    @Test
    void create() {
        RoleDto roleDto = new RoleDto();
        roleDto.setNom("ADMIN");
        RoleDto roleDtoSave = roleService.create(roleDto);
        Assertions.assertNotNull(roleDtoSave);
    }

    @Test
    void update() {
        RoleDto roleDto = roleService.get(1);
        roleDto.setNom("SUPER_ADMIN");
        RoleDto roleDtoUpdate = roleService.update(1, roleDto);
        Assertions.assertNotNull(roleDtoUpdate);
    }

    @Test
    void remove() {
        roleService.remove(1);
        Assertions.assertTrue(true);
    }

    @Test
    void get() {
        RoleDto roleDto = roleService.get(1);
        Assertions.assertNotNull(roleDto);
    }

    @Test
    void getAll() {
        List<RoleDto> roleDtos = roleService.getAll();
        Assertions.assertFalse(roleDtos.isEmpty());
    }
}