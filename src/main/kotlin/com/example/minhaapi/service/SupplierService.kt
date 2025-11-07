package com.example.minhaapi.service

import com.example.minhaapi.model.Supplier
import org.springframework.stereotype.Service

@Service
interface SupplierService {
    fun create(supplier: Supplier): String
    fun update(id: Long, supplier: Supplier): String
    fun getAll(): List<Supplier>
    fun getById(id: Long): Any
    fun delete(id: Long): String
}