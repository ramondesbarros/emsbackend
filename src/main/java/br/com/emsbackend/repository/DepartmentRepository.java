package br.com.emsbackend.repository;

import br.com.emsbackend.dto.DepartmentDTO;
import br.com.emsbackend.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentDTO, Long> {

    @Query(value = "SELECT * FROM department e WHERE e.id = :id", nativeQuery = true)
    DepartmentDTO findDepartmentById(@Param("id") Long id);
}
