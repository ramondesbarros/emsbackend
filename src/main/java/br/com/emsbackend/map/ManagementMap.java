package br.com.emsbackend.map;

import br.com.emsbackend.dto.ManagementDTO;
import br.com.emsbackend.request.ManagementRequest;
import br.com.emsbackend.response.ManagementResponse;
import org.springframework.stereotype.Component;

@Component
public class ManagementMap {

    public ManagementDTO requestToDTO(ManagementRequest request) {

        return new ManagementDTO(request.getTitle(), request.getDescription(), request.isCompleted());
    }

    public ManagementResponse dtoToResponse(ManagementDTO dto) {

        return new ManagementResponse(dto.getTitle(), dto.getDescription());
    }

    public ManagementDTO requestToDTOPut(Long id, ManagementRequest request) {

        ManagementDTO managementDTO = new ManagementDTO();

        managementDTO.setId(id);
        managementDTO.setTitle(request.getTitle());
        managementDTO.setDescription(request.getDescription());
        managementDTO.setCompleted(request.isCompleted());

        return managementDTO;
    }

}
