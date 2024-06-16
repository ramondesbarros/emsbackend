package br.com.emsbackend.service.impl;

import br.com.emsbackend.dto.EmployeeDTO;
import br.com.emsbackend.map.EmployeeMap;
import br.com.emsbackend.repository.EmployeeRepository;
import br.com.emsbackend.request.EmployeeRequest;
import br.com.emsbackend.response.EmployeeResponse;
import br.com.emsbackend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMap map;

    @Override
    public void create(EmployeeRequest employee) {

        employeeRepository.save(map.requestToDTO(employee));
    }

    @Override
    public EmployeeResponse read(Long id) throws Exception {

        EmployeeDTO employeeDTO2 = employeeRepository.getById(id);

        return map.dtoToResponse(employeeDTO2);
    }

    @Override
    public List<EmployeeResponse> readAll() {

        List<EmployeeDTO> employees = employeeRepository.findAll();

        List<EmployeeResponse> employeesResponse = employees.stream()
                .map(employee -> new EmployeeResponse(employee.getFirstName(), employee.getLastName()))
                .collect(Collectors.toList());

        return employeesResponse;
    }

    @Override
    public void updatePut(Long id, EmployeeRequest updateEmployee) {

        employeeRepository.save(map.requestToDTOPut(id, updateEmployee));
    }

    @Override
    public void updatePatch(Long id, Map<String, Object> updateEmployee) throws NoSuchFieldException, IllegalAccessException {

        EmployeeDTO employeeFind = employeeRepository.findEmployeeById(id);

        for (Map.Entry<String, Object> entry : updateEmployee.entrySet()) {

            Class<?> classe = EmployeeDTO.class;

            Field atributo = classe.getDeclaredField(entry.getKey());
            atributo.setAccessible(true);
            atributo.set(employeeFind, entry.getValue());
        }

        employeeRepository.save(employeeFind);
    }

    @Override
    public void delete(Long id) {

        employeeRepository.deleteById(id);
    }
}
