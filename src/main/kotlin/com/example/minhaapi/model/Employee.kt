package com.example.minhaapi.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Employees")
data class Employee(
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
val id: Long,
val name: String,
val role: String,
val salary: Double
)