package br.com.emsbackend.dto;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee")
public class EmployeeDTO {

    public EmployeeDTO() {
        super();
    }

    public EmployeeDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentDTO department;

    @ManyToOne
    @JoinColumn(name = "management_id")
    private ManagementDTO management;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }

    public ManagementDTO getManagement() {
        return management;
    }

    public void setManagement(ManagementDTO management) {
        this.management = management;
    }
}
