package sn.isi.parcinfo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.isi.parcinfo.dto.IngenieurDto;
import sn.isi.parcinfo.entities.Ingenieur;

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
        ingenieur.setEmail("mouhacent@gmail.com");
        ingenieur.setEtat(1);
        ingenieur.setPassword("passer123");

        IngenieurDto ingenieurSave = ingenieurService.create(ingenieur);

        Assertions.assertNotNull(ingenieurSave);
    }

    @Test
    void update() {
    }

    @Test
    void remove() {
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }
}