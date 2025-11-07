package com.example.minhaapi.controller

import com.example.minhaapi.model.Customer
import com.example.minhaapi.service.CustomerServiceImpl
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "Customer Controller", description = "Operações com clientes")
@RestController
@RequestMapping("/api/customer")
class CustomerController(
    private val service: CustomerServiceImpl
) {

    @Operation(summary = "Criar um novo cliente")
    @PostMapping
    fun create(@RequestBody customer: Customer): String = service.create(customer)

    @Operation(summary = "Atualizar um novo cliente")
    @PutMapping
    fun update(@RequestBody customer: Customer): String =
        service.update(customer)

    @Operation(summary = "Listar todos os clientes")
    @GetMapping
    fun getAll(): List<Customer> = service.getAll()

    @Operation(summary = "Buscar cliente por ID")
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Any = service.getById(id)

    @Operation(summary = "Deletar cliente por ID")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): String = service.delete(id)
}
