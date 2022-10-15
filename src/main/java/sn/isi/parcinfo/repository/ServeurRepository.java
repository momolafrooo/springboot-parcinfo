package sn.isi.parcinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.parcinfo.entities.Serveur;

import java.util.Optional;

public interface ServeurRepository extends JpaRepository<Serveur, Integer> {
    Optional<Serveur> findByNom(String nom);
}
