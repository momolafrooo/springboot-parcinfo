package sn.isi.parcinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.parcinfo.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
