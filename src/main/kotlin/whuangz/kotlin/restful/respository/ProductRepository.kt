package whuangz.kotlin.restful.respository

import org.springframework.data.jpa.repository.JpaRepository
import whuangz.kotlin.restful.entity.Product

interface ProductRepository: JpaRepository<Product, String> {

}