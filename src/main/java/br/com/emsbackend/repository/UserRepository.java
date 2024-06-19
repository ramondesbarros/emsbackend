package br.com.emsbackend.repository;

import br.com.emsbackend.dto.EmployeeDTO;
import br.com.emsbackend.security.Role;
import br.com.emsbackend.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user u WHERE u.user_name = :usernameOrEmail OR u.email = :usernameOrEmail", nativeQuery = true)
    User findByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);

}
