package br.com.emsbackend.service;

import br.com.emsbackend.request.DepartmentRequest;
import br.com.emsbackend.response.DepartmentResponse;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    void create(DepartmentRequest department);

    DepartmentResponse read(Long id) throws Exception;

    List<DepartmentResponse> readAll();

    void updatePut(Long id, DepartmentRequest updateDepartment);

    void updatePatch(Long id, Map<String, Object> updateDepartment) throws NoSuchFieldException, IllegalAccessException;

    void delete(Long id);

}
