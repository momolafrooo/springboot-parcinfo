package sn.isi.parcinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.parcinfo.entities.Serveur;

public interface ServeurRepository extends JpaRepository<Serveur, Integer> {
}
