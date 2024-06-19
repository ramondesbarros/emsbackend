package br.com.emsbackend.map;


import br.com.emsbackend.dto.DepartmentDTO;
import br.com.emsbackend.request.DepartmentRequest;
import br.com.emsbackend.response.DepartmentResponse;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMap {

    public DepartmentDTO requestToDTO(DepartmentRequest request) {

        return new DepartmentDTO(request.getDepartmentName(), request.getDepartmentDescription());
    }

    public DepartmentResponse dtoToResponse(DepartmentDTO dto) {

        return new DepartmentResponse(dto.getDepartmentName(), dto.getDepartmentDescription());
    }

    public DepartmentDTO requestToDTOPut(Long id, DepartmentRequest request) {

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setDepartmentName(request.getDepartmentName());
        departmentDTO.setDepartmentDescription(request.getDepartmentDescription());

        return departmentDTO;
    }

}
