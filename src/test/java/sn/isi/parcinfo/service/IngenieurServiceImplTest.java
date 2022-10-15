package sn.isi.parcinfo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.isi.parcinfo.dto.IngenieurDto;
import sn.isi.parcinfo.entities.Ingenieur;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class IngenieurServiceImplTest {

    @Autowired
    private IIngenieurService ingenieurService;

    @Test
    void create() {
        IngenieurDto ingenieur = new IngenieurDto();
        ingenieur.setNom("FALL");
        ingenieur.setPrenom("Mohamed");
        ingenieur.setEmail("mouhacent1@gmail.com");
        ingenieur.setEtat(1);
        ingenieur.setPassword("passer123");

        IngenieurDto ingenieurSave = ingenieurService.create(ingenieur);

        Assertions.assertNotNull(ingenieurSave);
    }

    @Test
    void update() {
        IngenieurDto ingenieur = ingenieurService.get(1);
        ingenieur.setEtat(0);

        IngenieurDto ingenieurUpdate = ingenieurService.update(1, ingenieur);

        Assertions.assertNotNull(ingenieurUpdate);
    }

    @Test
    void remove() {
        ingenieurService.remove(1);
        Assertions.assertTrue(true);
    }

    @Test
    void get() {
        IngenieurDto ingenieur = ingenieurService.get(1);
        Assertions.assertNotNull(ingenieur);
    }

    @Test
    void getAll() {
        List<IngenieurDto> ingenieurDtos = ingenieurService.getAll();
        Assertions.assertEquals(1, ingenieurDtos.size());
    }
}