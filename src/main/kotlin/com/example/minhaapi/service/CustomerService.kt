package com.example.minhaapi.service

import com.example.minhaapi.model.Customer
import org.springframework.stereotype.Service

@Service
interface CustomerService {
    fun create(customer: Customer): String
    fun update(customer: Customer): String
    fun getAll(): List<Customer>
    fun getById(id: Long): Any
    fun delete(id: Long): String
}