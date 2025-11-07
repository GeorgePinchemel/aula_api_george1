package com.example.minhaapi.repository

import com.example.minhaapi.model.Customer
import com.example.minhaapi.model.Employee
import com.example.minhaapi.model.Order
import com.example.minhaapi.model.Product
import com.example.minhaapi.model.Supplier
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long>

@Repository
interface CustomerRepository : JpaRepository<Customer, Long>

@Repository
interface EmployeeRepository : JpaRepository<Employee, Long>

@Repository
interface OrderRepository : JpaRepository<Order, Long>

@Repository
interface SupplierRepository : JpaRepository<Supplier, Long>