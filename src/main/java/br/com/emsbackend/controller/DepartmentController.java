package br.com.emsbackend.controller;

import br.com.emsbackend.request.DepartmentRequest;
import br.com.emsbackend.response.DepartmentResponse;
import br.com.emsbackend.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentRequest> create(@RequestBody DepartmentRequest employee) {

        departmentService.create(employee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> read(@PathVariable("id") Long id) {

        try {

            DepartmentResponse employeeResponse = departmentService.read(id);

            return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> readAll() {

        return ResponseEntity.ok(departmentService.readAll());
    }

    @PutMapping("{id}/put")
    public ResponseEntity<DepartmentRequest> updatePut(@PathVariable("id") Long id, @RequestBody DepartmentRequest updateEmployee) {

        departmentService.updatePut(id, updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    @PatchMapping("{id}/patch")
    public ResponseEntity<Map<String, Object>> updatePatch(@PathVariable("id") Long id, @RequestBody Map<String, Object> updateEmployee) /*throws NoSuchFieldException, IllegalAccessException*/ {

        try {

            departmentService.updatePatch(id, updateEmployee);

        } catch (NoSuchFieldException | IllegalAccessException e) {

            LOGGER.error("Falha na atualização dos dados");
        }

        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id) {

        departmentService.delete(id);
    }
}
