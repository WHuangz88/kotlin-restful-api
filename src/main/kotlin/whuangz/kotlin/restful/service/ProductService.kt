package whuangz.kotlin.restful.service

import whuangz.kotlin.restful.model.CreateProductRequest
import whuangz.kotlin.restful.model.ProductResponse

interface ProductService {
    fun create(request: CreateProductRequest): ProductResponse
    fun get(id: String): ProductResponse
}