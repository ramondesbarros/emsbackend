package br.com.emsbackend.repository;

import br.com.emsbackend.dto.DepartmentDTO;
import br.com.emsbackend.dto.ManagementDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagementRepository extends JpaRepository<ManagementDTO, Long>  {

    @Query(value = "SELECT * FROM management e WHERE e.id = :id", nativeQuery = true)
    ManagementDTO findManagementById(@Param("id") Long id);

}
