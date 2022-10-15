package sn.isi.parcinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.parcinfo.entities.Service;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    Optional<Service> findByPort(int port);
}
