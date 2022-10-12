package sn.isi.parcinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.parcinfo.entities.Ingenieur;

import java.util.Optional;

public interface IngenieurRepository extends JpaRepository<Ingenieur, Integer> {

    Optional<Ingenieur> findByEmail(String email);
}
