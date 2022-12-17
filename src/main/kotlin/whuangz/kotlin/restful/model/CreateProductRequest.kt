package whuangz.kotlin.restful.model

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CreateProductRequest(

    @field:NotBlank
    val id: String?,

    @field:NotBlank
    var name: String?,

    @field:NotNull
    @field:Min(value = 1)
    var price: Long?,

    @field:NotNull
    @field:Min(value = 0)
    var quantity: Int?

)