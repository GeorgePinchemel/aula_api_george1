package com.example.minhaapi.service

import com.example.minhaapi.model.Employee
import com.example.minhaapi.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeServiceImpl(
    private val repository: EmployeeRepository
) : EmployeeService {

    override fun create(employee: Employee): String {
        repository.save(employee)
        return "Funcionário '${employee.name}' foi cadastrado na base de dados."
    }

    override fun update(id: Long, employee: Employee): String {
        val existing = repository.findById(id)
        return if (existing.isPresent) {
            repository.save(employee.copy(id = id))
            "Funcionário '${employee.name}' foi alterado com sucesso."
        } else {
            "Funcionário com ID $id não existe na base de dados."
        }
    }

    override fun getAll(): List<Employee> = repository.findAll()

    override fun getById(id: Long): Any {
        val found = repository.findById(id)
        return if (found.isPresent) {
            found.get() // retorna o Employee
        } else {
            "Funcionário com ID $id não existe na base de dados."
        }
    }

    override fun delete(id: Long): String {
        val existing = repository.findById(id)
        return if (existing.isPresent) {
            repository.deleteById(id)
            "Funcionário '${existing.get().name}' foi removido com sucesso."
        } else {
            "Funcionário com ID $id não existe na base de dados."
        }
    }
}