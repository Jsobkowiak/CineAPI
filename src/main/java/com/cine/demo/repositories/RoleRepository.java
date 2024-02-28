package com.cine.demo.repositories;

import com.cine.demo.entities.cineScape.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
