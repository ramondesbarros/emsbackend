package br.com.emsbackend.repository;


import br.com.emsbackend.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Long> {

    @Query(value = "SELECT * FROM employee e WHERE e.id = :id", nativeQuery = true)
    EmployeeDTO findEmployeeById(@Param("id") Long id);
}
