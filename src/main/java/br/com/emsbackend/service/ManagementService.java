package br.com.emsbackend.service;

import br.com.emsbackend.request.EmployeeRequest;
import br.com.emsbackend.request.ManagementRequest;
import br.com.emsbackend.response.EmployeeResponse;
import br.com.emsbackend.response.ManagementResponse;

import java.util.List;
import java.util.Map;

public interface ManagementService {

    void create(ManagementRequest management);

    ManagementResponse read(Long id) throws Exception;

    List<ManagementResponse> readAll();

    void updatePut(Long id, ManagementRequest managementUpdate);

    void updatePatch(Long id, Map<String, Object> update) throws NoSuchFieldException, IllegalAccessException;

    void delete(Long id);

}
