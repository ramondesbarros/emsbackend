package br.com.emsbackend.service;

import br.com.emsbackend.request.EmployeeRequest;
import br.com.emsbackend.response.EmployeeResponse;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    void create(EmployeeRequest employee);

    EmployeeResponse read(Long id) throws Exception;

    List<EmployeeResponse> readAll();

    void updatePut(Long id, EmployeeRequest updateEmployee);

    void updatePatch(Long id, Map<String, Object> updateEmployee) throws NoSuchFieldException, IllegalAccessException;

    void delete(Long id);
}
