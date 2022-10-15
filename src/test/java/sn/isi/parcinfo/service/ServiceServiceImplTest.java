package sn.isi.parcinfo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.isi.parcinfo.dto.ServeurDto;
import sn.isi.parcinfo.dto.ServiceDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ServiceServiceImplTest {

    @Autowired
    private IServiceService serviceService;

    @Test
    void create() {
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setPort(1200);
        ServiceDto serviceDtoSave = serviceService.create(serviceDto);
        Assertions.assertNotNull(serviceDtoSave);
    }

    @Test
    void update() {
        ServiceDto serviceDto = serviceService.get(1);
        serviceDto.setPort(1220);
        ServiceDto serviceDtoUpdate = serviceService.update(1, serviceDto);
        Assertions.assertNotNull(serviceDtoUpdate);
    }

    @Test
    void remove() {
        serviceService.remove(1);
        Assertions.assertTrue(true);
    }

    @Test
    void get() {
        ServiceDto serviceDto = serviceService.get(1);
        Assertions.assertNotNull(serviceDto);
    }

    @Test
    void getAll() {
        List<ServiceDto> serviceDtos = serviceService.getAll();
        Assertions.assertFalse(serviceDtos.isEmpty());
    }
}