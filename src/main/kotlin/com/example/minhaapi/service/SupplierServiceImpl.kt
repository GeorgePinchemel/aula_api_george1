package com.example.minhaapi.service

import com.example.minhaapi.model.Supplier
import com.example.minhaapi.repository.SupplierRepository
import org.springframework.stereotype.Service

@Service
class SupplierServiceImpl(
    private val repository: SupplierRepository
) : SupplierService {

    override fun create(supplier: Supplier): String {
        repository.save(supplier)
        return "Fornecedor '${supplier.name}' foi cadastrado na base de dados."
    }

    override fun update(id: Long, supplier: Supplier): String {
        val existing = repository.findById(id)
        return if (existing.isPresent) {
            repository.save(supplier.copy(id = id))
            "Fornecedor '${supplier.name}' foi alterado com sucesso."
        } else {
            "Fornecedor com ID $id não existe na base de dados."
        }
    }

    override fun getAll(): List<Supplier> = repository.findAll()

    override fun getById(id: Long): Any {
        val found = repository.findById(id)
        return if (found.isPresent) {
            found.get() // retorna o Supplier
        } else {
            "Fornecedor com ID $id não existe na base de dados."
        }
    }

    override fun delete(id: Long): String {
        val existing = repository.findById(id)
        return if (existing.isPresent) {
            repository.deleteById(id)
            "Fornecedor '${existing.get().name}' foi removido com sucesso."
        } else {
            "Fornecedor com ID $id não existe na base de dados."
        }
    }
}