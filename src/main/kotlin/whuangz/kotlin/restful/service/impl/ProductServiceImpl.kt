package whuangz.kotlin.restful.service.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import whuangz.kotlin.restful.entity.Product
import whuangz.kotlin.restful.error.NotFoundException
import whuangz.kotlin.restful.model.CreateProductRequest
import whuangz.kotlin.restful.model.ProductResponse
import whuangz.kotlin.restful.respository.ProductRepository
import whuangz.kotlin.restful.service.ProductService
import whuangz.kotlin.restful.validation.ValidationUtil
import java.util.*

@Service
class ProductServiceImpl(
    val productRepo: ProductRepository,
    val validationUtil: ValidationUtil
): ProductService {
    override fun create(request: CreateProductRequest): ProductResponse {
        validationUtil.validate(request)

        val product = Product(
            id = request.id!!,
            name = request.name!!,
            price = request.price!!,
            quantity = request.quantity!!,
            createdAt = Date(),
            updatedAt = null
        )

        productRepo.save(product)
        return getProductResponse(product)

    }

    override fun get(id: String): ProductResponse {
        val product = productRepo.findByIdOrNull(id)
        if (product == null) {
            throw NotFoundException()
        } else {
            return getProductResponse(product)
        }
    }

    private fun getProductResponse(product: Product): ProductResponse {
        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }

}