package br.com.emsbackend.service.impl;

import br.com.emsbackend.dto.DepartmentDTO;
import br.com.emsbackend.dto.EmployeeDTO;
import br.com.emsbackend.map.DepartmentMap;
import br.com.emsbackend.repository.DepartmentRepository;
import br.com.emsbackend.request.DepartmentRequest;
import br.com.emsbackend.response.DepartmentResponse;
import br.com.emsbackend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentMap map;


    @Override
    public void create(DepartmentRequest department) {

        departmentRepository.save(map.requestToDTO(department));

    }

    @Override
    public DepartmentResponse read(Long id) throws Exception {

        DepartmentDTO employeeDTO2 = departmentRepository.getById(id);

        return map.dtoToResponse(employeeDTO2);
    }

    @Override
    public List<DepartmentResponse> readAll() {

        List<DepartmentDTO> departments = departmentRepository.findAll();

        List<DepartmentResponse> departmentResponse = departments.stream()
                .map(department -> new DepartmentResponse(department.getDepartmentName(), department.getDepartmentDescription()))
                .collect(Collectors.toList());

        return departmentResponse;

    }

    @Override
    public void updatePut(Long id, DepartmentRequest updateDepartment) {

        departmentRepository.save(map.requestToDTOPut(id, updateDepartment));


    }

    @Override
    public void updatePatch(Long id, Map<String, Object> updateDepartment) throws NoSuchFieldException, IllegalAccessException {

        DepartmentDTO departmentFind = departmentRepository.findDepartmentById(id);

        for (Map.Entry<String, Object> entry : updateDepartment.entrySet()) {

            Class<?> classe = EmployeeDTO.class;

            Field atributo = classe.getDeclaredField(entry.getKey());
            atributo.setAccessible(true);
            atributo.set(departmentFind, entry.getValue());
        }

        departmentRepository.save(departmentFind);

    }

    @Override
    public void delete(Long id) {

        departmentRepository.deleteById(id);

    }
}
