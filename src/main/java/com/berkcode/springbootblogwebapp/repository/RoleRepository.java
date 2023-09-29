package com.berkcode.springbootblogwebapp.repository;

import com.berkcode.springbootblogwebapp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
