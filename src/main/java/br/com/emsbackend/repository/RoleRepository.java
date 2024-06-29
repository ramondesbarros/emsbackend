package br.com.emsbackend.repository;

import br.com.emsbackend.dto.EmployeeDTO;
import br.com.emsbackend.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
