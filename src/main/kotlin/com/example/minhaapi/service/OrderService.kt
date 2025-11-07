package com.example.minhaapi.service

import com.example.minhaapi.model.Order
import org.springframework.stereotype.Service

@Service
interface OrderService {
    fun create(order: Order): String
    fun update(id: Long, order: Order): String
    fun getAll(): List<Order>
    fun getById(id: Long): Any
    fun delete(id: Long): String
}