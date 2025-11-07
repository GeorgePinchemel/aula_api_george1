package com.example.minhaapi.service

import com.example.minhaapi.model.Order
import com.example.minhaapi.repository.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(
    private val repository: OrderRepository
) : OrderService {

    override fun create(order: Order): String {
        repository.save(order)
        return "Pedido #${order.id} foi cadastrado na base de dados."
    }

    override fun update(id: Long, order: Order): String {
        val existing = repository.findById(id)
        return if (existing.isPresent) {
            repository.save(order.copy(id = id))
            "Pedido #$id foi alterado com sucesso."
        } else {
            "Pedido #$id não existe na base de dados."
        }
    }

    override fun getAll(): List<Order> = repository.findAll()

    override fun getById(id: Long): Any {
        val found = repository.findById(id)
        return if (found.isPresent) {
            found.get() // retorna a Order
        } else {
            "Pedido com ID $id não existe na base de dados."
        }
    }

    override fun delete(id: Long): String {
        val existing = repository.findById(id)
        return if (existing.isPresent) {
            repository.deleteById(id)
            "Pedido #$id foi removido com sucesso."
        } else {
            "Pedido #$id não existe na base de dados."
        }
    }
}