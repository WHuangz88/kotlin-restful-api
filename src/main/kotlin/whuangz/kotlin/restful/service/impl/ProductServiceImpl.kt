package whuangz.kotlin.restful.service.impl

import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import whuangz.kotlin.restful.entity.Product
import whuangz.kotlin.restful.error.NotFoundException
import whuangz.kotlin.restful.model.CreateProductRequest
import whuangz.kotlin.restful.model.ListProductRequest
import whuangz.kotlin.restful.model.ProductResponse
import whuangz.kotlin.restful.model.UpdateProductRequest
import whuangz.kotlin.restful.respository.ProductRepository
import whuangz.kotlin.restful.service.ProductService
import whuangz.kotlin.restful.validation.ValidationUtil
import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors

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
        val product = findProductByIdOrThrowNotFound(id)

        return getProductResponse(product)
    }

    override fun update(id: String, request: UpdateProductRequest): ProductResponse {
        val product = findProductByIdOrThrowNotFound(id)

        validationUtil.validate(request)

        product.apply {
            name = request.name!!
            price = request.price!!
            quantity = request.quantity!!
            updatedAt = Date()
        }

        productRepo.save(product)
        return getProductResponse(product)
    }

    override fun delete(id: String) {
        val product = findProductByIdOrThrowNotFound(id)
        productRepo.delete(product)
    }

    override fun list(request: ListProductRequest): List<ProductResponse> {
        val page = productRepo.findAll(PageRequest.of(request.page, request.size))
        var products: List<Product> = page.get().collect(Collectors.toList())

        return products.map {
            getProductResponse(it)
        }
    }

    private fun findProductByIdOrThrowNotFound(id: String): Product {
        return productRepo.findByIdOrNull(id) ?: throw NotFoundException()
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