package com.example.minhaapi.controller

import com.example.minhaapi.model.Supplier
import com.example.minhaapi.service.SupplierServiceImpl
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "Supplier Controller", description = "Operações com fornecedores")
@RestController
@RequestMapping("/api/supplier")
class SupplierController(
    private val service: SupplierServiceImpl
) {

    @Operation(summary = "Criar novo fornecedor")
    @PostMapping
    fun create(@RequestBody supplier: Supplier): String = service.create(supplier)

    @Operation(summary = "Atualizar fornecedor por ID")
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody supplier: Supplier): String =
        service.update(id, supplier)

    @Operation(summary = "Listar todos os fornecedors")
    @GetMapping
    fun getAll(): List<Supplier> = service.getAll()

    @Operation(summary = "Buscar fornecedor por ID")
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Any = service.getById(id)

    @Operation(summary = "Deletar fornecedor por ID")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): String = service.delete(id)
}
