package br.com.emsbackend.service.impl;

import br.com.emsbackend.dto.EmployeeDTO;
import br.com.emsbackend.dto.ManagementDTO;
import br.com.emsbackend.map.EmployeeMap;
import br.com.emsbackend.map.ManagementMap;
import br.com.emsbackend.repository.EmployeeRepository;
import br.com.emsbackend.repository.ManagementRepository;
import br.com.emsbackend.request.ManagementRequest;
import br.com.emsbackend.response.EmployeeResponse;
import br.com.emsbackend.response.ManagementResponse;
import br.com.emsbackend.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ManagementServiceImpl implements ManagementService {

    @Autowired
    private ManagementRepository managementRepository;

    @Autowired
    private ManagementMap map;


    @Override
    public void create(ManagementRequest management) {

        managementRepository.save(map.requestToDTO(management));

    }

    @Override
    public ManagementResponse read(Long id) throws Exception {
        return null;
    }

    @Override
    public List<ManagementResponse> readAll() {

        List<ManagementDTO> managements = managementRepository.findAll();

        List<ManagementResponse> managementResponse = managements.stream()
                .map(management -> new ManagementResponse(management.getTitle(), management.getDescription()))
                .collect(Collectors.toList());

        return managementResponse;


    }

    @Override
    public void updatePut(Long id, ManagementRequest managementUpdate) {

        managementRepository.save(map.requestToDTOPut(id, managementUpdate));

    }

    @Override
    public void updatePatch(Long id, Map<String, Object> update) throws NoSuchFieldException, IllegalAccessException {

        ManagementDTO managementFind = managementRepository.findManagementById(id);

        for (Map.Entry<String, Object> entry : update.entrySet()) {

            Class<?> classe = EmployeeDTO.class;

            Field atributo = classe.getDeclaredField(entry.getKey());
            atributo.setAccessible(true);
            atributo.set(managementFind, entry.getValue());
        }

        managementRepository.save(managementFind);

    }

    @Override
    public void delete(Long id) {

        managementRepository.deleteById(id);
    }
}
