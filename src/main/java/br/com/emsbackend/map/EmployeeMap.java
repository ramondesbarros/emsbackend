package br.com.emsbackend.map;

import br.com.emsbackend.dto.EmployeeDTO;
import br.com.emsbackend.request.EmployeeRequest;
import br.com.emsbackend.response.EmployeeResponse;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMap {

    public EmployeeDTO requestToDTO(EmployeeRequest request) {

        String firstName = request.getFirstName();
        return new EmployeeDTO(firstName, request.getLastName(), request.getEmail());
    }

    public EmployeeResponse dtoToResponse(EmployeeDTO dto) {

        return new EmployeeResponse(dto.getFirstName(), dto.getLastName());
    }

    public EmployeeDTO requestToDTOPut(Long id, EmployeeRequest request) {

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId(id);
        employeeDTO.setFirstName(request.getFirstName());
        employeeDTO.setLastName(request.getLastName());
        employeeDTO.setEmail(request.getEmail());

        return employeeDTO;
    }
}
