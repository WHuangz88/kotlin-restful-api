package whuangz.kotlin.restful.controller

import jakarta.validation.ConstraintViolationException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import whuangz.kotlin.restful.error.NotFoundException
import whuangz.kotlin.restful.model.WebResponse

@RestControllerAdvice
class ErrorController {
    @ExceptionHandler(value= [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String> {
        return WebResponse(
            code = 400,
            status = "BAD REQUEST",
            data = constraintViolationException.message ?: "error"
        )
    }

    @ExceptionHandler(value= [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): WebResponse<String> {
        return WebResponse(
            code = 404,
            status = "NOT FOUND",
            data = "Not Found"
        )
    }
}