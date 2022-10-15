package sn.isi.parcinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.parcinfo.entities.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByNom(String nom);
}
