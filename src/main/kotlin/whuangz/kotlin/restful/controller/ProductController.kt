package whuangz.kotlin.restful.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import whuangz.kotlin.restful.entity.Product
import whuangz.kotlin.restful.model.*
import whuangz.kotlin.restful.service.ProductService

@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
        value= ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody request: CreateProductRequest): WebResponse<ProductResponse> {
        val productResp = productService.create(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResp
        )
    }

    @GetMapping(
        value = ["/api/products/{id}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("id") id: String): WebResponse<ProductResponse> {
        val productResp = productService.get(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResp
        )
    }

    @PutMapping(
        value = ["/api/products/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(
        @PathVariable("id") id: String,
        @RequestBody request: UpdateProductRequest
    ) : WebResponse<ProductResponse> {
        val productResp = productService.update(id, request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = productResp
        )
    }

    @DeleteMapping(
        value = ["/api/products/{id}"],
        produces = ["application/json"]
    )
    fun deleteProduct(
        @PathVariable("id") id: String
    ): WebResponse<String> {
        productService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(
        value = ["/api/products"],
        produces = ["application/json"]
    )
    fun listProducts(
        @RequestParam(value="size", defaultValue = "10") size: Int,
        @RequestParam(value="page", defaultValue = "0") page: Int
    ): WebResponse<List<ProductResponse>> {
        val request = ListProductRequest(page= page, size = size)
        val response = productService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}