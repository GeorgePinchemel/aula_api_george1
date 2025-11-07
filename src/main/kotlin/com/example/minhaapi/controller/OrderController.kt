package com.example.minhaapi.controller

import com.example.minhaapi.model.Order
import com.example.minhaapi.service.OrderServiceImpl
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "Order Controller", description = "Operações com pedidos")
@RestController
@RequestMapping("/api/order")
class OrderController(
    private val service: OrderServiceImpl
) {

    @Operation(summary = "Criar um novo pedido")
    @PostMapping
    fun create(@RequestBody order: Order): String = service.create(order)

    @Operation(summary = "Atualizar pedido por ID")
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody order: Order): String =
        service.update(id, order)

    @Operation(summary = "Listar todos os pedidos")
    @GetMapping
    fun getAll(): List<Order> = service.getAll()

    @Operation(summary = "Buscar pedido por ID")
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Any = service.getById(id)

    @Operation(summary = "Deletar pedido por ID")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): String = service.delete(id)
}
