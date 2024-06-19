package br.com.emsbackend.controller;

import br.com.emsbackend.request.ManagementRequest;
import br.com.emsbackend.response.ManagementResponse;
import br.com.emsbackend.service.ManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/management")
public class ManagementController {

    private static Logger LOGGER = LoggerFactory.getLogger(ManagementController.class);

    @Autowired
    private ManagementService managementService;

    @PostMapping
    public ResponseEntity<ManagementRequest> create(@RequestBody ManagementRequest employee) {

        managementService.create(employee);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ManagementResponse> read(@PathVariable("id") Long id) {

        try {

            ManagementResponse managementResponse = managementService.read(id);

            return new ResponseEntity<>(managementResponse, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<ManagementResponse>> readAll() {

        return ResponseEntity.ok(managementService.readAll());
    }

    @PutMapping("{id}/put")
    public ResponseEntity<ManagementRequest> updatePut(@PathVariable("id") Long id, @RequestBody ManagementRequest updateEmployee) {

        managementService.updatePut(id, updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    @PatchMapping("{id}/patch")
    public ResponseEntity<Map<String, Object>> updatePatch(@PathVariable("id") Long id, @RequestBody Map<String, Object> updateEmployee) /*throws NoSuchFieldException, IllegalAccessException*/ {

        try {

            managementService.updatePatch(id, updateEmployee);

        } catch (NoSuchFieldException | IllegalAccessException e) {

            LOGGER.error("Falha na atualização dos dados");
        }

        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id) {

        managementService.delete(id);
    }

}
