package whuangz.kotlin.restful.auth

import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import whuangz.kotlin.restful.error.UnAuthorizedException
import whuangz.kotlin.restful.respository.ApiRepository
import java.lang.Exception

@Component
class ApiKeyInterceptor(val apiRepository: ApiRepository): WebRequestInterceptor {
    override fun preHandle(request: WebRequest) {
        val apiKey = request.getHeader("X-Api-Key") ?: throw UnAuthorizedException()

        if (!apiRepository.existsById(apiKey)) {
            throw UnAuthorizedException()
        }
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {
        //
    }

    override fun afterCompletion(request: WebRequest, ex: Exception?) {
        //
    }
}