package com.example.minhaapi.service

import com.example.minhaapi.model.Customer
import com.example.minhaapi.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl(
    private val repository: CustomerRepository
) : CustomerService {

    override fun create(customer: Customer): String {
        repository.save(customer)
        return "Cliente '${customer.name}' foi cadastrado na base de dados."
    }

    override fun update(customer: Customer): String {
        val id = customer.id ?: return "ID do cliente não pode ser nulo."

        val existing = repository.findById(id)
        return if (existing.isPresent) {
            repository.save(customer) // ✅ Passa o Customer inteiro, não o id
            "Cliente '${customer.name}' foi alterado com sucesso."
        } else {
            "Cliente com ID $id não existe na base de dados."
        }
    }

    override fun getAll(): List<Customer> = repository.findAll()

    override fun getById(id: Long): Any {
        val found = repository.findById(id)
        return if (found.isPresent) {
            found.get() // retorna o Customer
        } else {
            "Cliente com ID $id não existe na base de dados."
        }
    }

    override fun delete(id: Long): String {
        val existing = repository.findById(id)
        return if (existing.isPresent) {
            val name = existing.get().name
            repository.deleteById(id)
            "Cliente '$name' foi removido com sucesso."
        } else {
            "Cliente com ID $id não existe na base de dados."
        }
    }
}
