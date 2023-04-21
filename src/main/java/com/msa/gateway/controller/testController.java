package com.msa.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/test")
public class testController {

    @GetMapping("/{id}")
    private Mono<ResponseEntity> getEmployeeById(@PathVariable String id) {
        return Mono.just(ResponseEntity.ok(id));
    }

//    @GetMapping("/{id}")
//    private Mono<Object> getEmployeeById(@PathVariable String id) {
//        return ;
//    }

//    @GetMapping
//    private Flux<Employee> getAllEmployees() {
//        return employeeRepository.findAllEmployees();
//    }
//
//    @PostMapping("/update")
//    private Mono<Employee> updateEmployee(@RequestBody Employee employee) {
//        return employeeRepository.updateEmployee(employee);
//    }
}
