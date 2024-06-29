package br.com.emsbackend.security;

import jakarta.persistence.*;

// https://github.com/neckeltech/spring-security-basic-authentication/blob/main/src/main/java/tech/neckel/security/security/WebSecurityConfig.java

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;


    public Long getId() {
        return id;
    }

    public void setRoleId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
