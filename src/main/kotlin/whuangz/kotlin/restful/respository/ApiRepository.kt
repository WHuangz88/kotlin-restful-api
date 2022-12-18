package whuangz.kotlin.restful.respository

import org.springframework.data.jpa.repository.JpaRepository
import whuangz.kotlin.restful.entity.ApiKey
import whuangz.kotlin.restful.entity.Product

interface ApiRepository: JpaRepository<ApiKey, String> {
}