package whuangz.kotlin.restful.service

import whuangz.kotlin.restful.model.CreateProductRequest
import whuangz.kotlin.restful.model.ProductResponse
import whuangz.kotlin.restful.model.UpdateProductRequest

interface ProductService {
    fun create(request: CreateProductRequest): ProductResponse
    fun get(id: String): ProductResponse
    fun update(id: String, request: UpdateProductRequest): ProductResponse
    fun delete(id: String)
}