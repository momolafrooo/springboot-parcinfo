package sn.isi.parcinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.parcinfo.entities.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
