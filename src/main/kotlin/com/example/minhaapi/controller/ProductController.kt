package com.example.minhaapi.controller

import com.example.minhaapi.model.Product
import com.example.minhaapi.service.ProductService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*

@Tag(name = "Product Controller", description = "Operações com produtos")
@RestController
@RequestMapping("/api")
class ProductController(private val productService: ProductService) {

    @Operation(summary = "Listar todos os produtos")
    @GetMapping("/product")
    fun getAll(): List<Product> = productService.getAll()

    @Operation(summary = "Buscar produto por ID")
    @GetMapping("/product/{id}")
    fun getById(@PathVariable id: Long): Product = productService.getById(id)

    @Operation(summary = "Criar um novo produto")
    @PostMapping("/product")
    fun create(@RequestBody product: Product): Product = productService.create(product)

    @Operation(summary = "Atualizar um produto existente")
    @PutMapping("/product")
    fun update(@RequestBody product: Product): String = productService.update(product)

    @Operation(summary = "Deletar um produto")
    @DeleteMapping("/product/{id}")
    fun delete(@PathVariable id: Long): String = productService.delete(id)
}