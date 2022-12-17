package whuangz.kotlin.restful.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import whuangz.kotlin.restful.entity.Product
import whuangz.kotlin.restful.model.CreateProductRequest
import whuangz.kotlin.restful.model.ProductResponse
import whuangz.kotlin.restful.model.UpdateProductRequest
import whuangz.kotlin.restful.model.WebResponse
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
}