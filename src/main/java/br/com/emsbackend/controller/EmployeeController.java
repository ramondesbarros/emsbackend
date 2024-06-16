package br.com.emsbackend.controller;

import br.com.emsbackend.request.EmployeeRequest;
import br.com.emsbackend.response.EmployeeResponse;
import br.com.emsbackend.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeRequest> create(@RequestBody EmployeeRequest employee) {

        employeeService.create(employee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> read(@PathVariable("id") Long id) {

        try {

            EmployeeResponse employeeResponse = employeeService.read(id);

            return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> readAll() {

        return ResponseEntity.ok(employeeService.readAll());
    }

    @PutMapping("{id}/put")
    public ResponseEntity<EmployeeRequest> updatePut(@PathVariable("id") Long id, @RequestBody EmployeeRequest updateEmployee) {

            employeeService.updatePut(id, updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    @PatchMapping("{id}/patch")
    public ResponseEntity<Map<String, Object>> updatePatch(@PathVariable("id") Long id, @RequestBody Map<String, Object> updateEmployee) /*throws NoSuchFieldException, IllegalAccessException*/ {

        try {

            employeeService.updatePatch(id, updateEmployee);

        } catch (NoSuchFieldException | IllegalAccessException e) {

            LOGGER.error("Falha na atualização dos dados");
        }

        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id) {

        employeeService.delete(id);
    }
}
