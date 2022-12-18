package whuangz.kotlin.restful.config

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import whuangz.kotlin.restful.entity.ApiKey
import whuangz.kotlin.restful.respository.ApiRepository

@Component
class ApiKeySeeder(val apiRepository: ApiRepository): ApplicationRunner {

    val apiKey = "SECRET"
    override fun run(args: ApplicationArguments?) {
        if (!apiRepository.existsById(apiKey)) {
            val entity = ApiKey(id = apiKey)
            apiRepository.save(entity)
        }
    }
}