package whuangz.kotlin.restful.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

data class ProductResponse(
    val id: String,
    val name: String,
    var price: Long,
    val quantity: Int,
    val createdAt: Date,
    val updatedAt: Date?
)