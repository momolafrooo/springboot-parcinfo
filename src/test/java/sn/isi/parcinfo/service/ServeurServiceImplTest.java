package sn.isi.parcinfo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.isi.parcinfo.dto.RoleDto;
import sn.isi.parcinfo.dto.ServeurDto;
import sn.isi.parcinfo.entities.Serveur;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ServeurServiceImplTest {

    @Autowired
    private IServeurService serveurService;

    @Test
    void create() {
        ServeurDto serveur = new ServeurDto();
        serveur.setNom("root");
        serveur.setAdrip("10.10.50.3");
        ServeurDto serveurSave = serveurService.create(serveur);
        Assertions.assertNotNull(serveurSave);
    }

    @Test
    void update() {
        ServeurDto serveur = serveurService.get(1);
        serveur.setNom("webserveur");
        ServeurDto serveurUpdate = serveurService.update(1, serveur);
        Assertions.assertNotNull(serveurUpdate);
    }

    @Test
    void remove() {
        serveurService.remove(1);
        Assertions.assertTrue(true);
    }

    @Test
    void get() {
        ServeurDto serveur = serveurService.get(1);
        Assertions.assertNotNull(serveur);
    }

    @Test
    void getAll() {
        List<ServeurDto> serveurDtos = serveurService.getAll();
        Assertions.assertFalse(serveurDtos.isEmpty());
    }
}