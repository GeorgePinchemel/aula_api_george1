package com.example.minhaapi.service

import com.example.minhaapi.model.Product
import org.springframework.stereotype.Service

@Service
interface ProductService {
    fun getAll(): List<Product>
    fun getById(id: Long): Product
    fun create(product: Product): Product
    fun update(product: Product): String
    fun delete(id: Long): String
}