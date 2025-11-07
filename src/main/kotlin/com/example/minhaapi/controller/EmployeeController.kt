package com.example.minhaapi.controller

import com.example.minhaapi.model.Employee
import com.example.minhaapi.service.EmployeeServiceImpl
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "Employee Controller", description = "Operações com funcionários")
@RestController
@RequestMapping("/api/employee")
class EmployeeController(
    private val service: EmployeeServiceImpl
) {

    @Operation(summary = "Criar um novo funcionário")
    @PostMapping
    fun create(@RequestBody employee: Employee): String = service.create(employee)

    @Operation(summary = "Atualizar funcionário por ID")
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody employee: Employee): String =
        service.update(id, employee)

    @Operation(summary = "Listar todos os funcionários")
    @GetMapping
    fun getAll(): List<Employee> = service.getAll()

    @Operation(summary = "Buscar funcionário por ID")
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Any = service.getById(id)

    @Operation(summary = "Deletar funcionário por ID")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): String = service.delete(id)
}
