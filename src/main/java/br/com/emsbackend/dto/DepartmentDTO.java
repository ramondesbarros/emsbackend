package br.com.emsbackend.dto;


import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "department")
public class DepartmentDTO {

    public DepartmentDTO() {
        super();

    }


    public DepartmentDTO(String departmentName, String departmentDescription) {
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_description")
    private String departmentDescription;

    @OneToMany(mappedBy = "department")
    private List<EmployeeDTO> employees;

    @ManyToMany(mappedBy = "departments")
    private Set<ManagementDTO> managements;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }

    public Set<ManagementDTO> getManagements() {
        return managements;
    }

    public void setManagements(Set<ManagementDTO> managements) {
        this.managements = managements;
    }
}
