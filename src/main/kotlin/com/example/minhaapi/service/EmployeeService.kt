package com.example.minhaapi.service

import com.example.minhaapi.model.Employee
import org.springframework.stereotype.Service

@Service
interface EmployeeService {
    fun create(employee: Employee): String
    fun update(id: Long, employee: Employee): String
    fun getAll(): List<Employee>
    fun getById(id: Long): Any
    fun delete(id: Long): String
}
