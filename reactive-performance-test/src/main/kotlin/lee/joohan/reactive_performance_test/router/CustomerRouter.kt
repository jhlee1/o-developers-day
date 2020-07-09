package lee.joohan.reactive_performance_test.router

import lee.joohan.reactive_performance_test.handler.CustomerRequestHandler
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.router

/**
 * Created by Joohan Lee on 2020/04/21
 *
 */

@Component
class CustomerRouter(val customerRequestHandler: CustomerRequestHandler) {
    @Bean
    fun customerRoutes(): RouterFunction<*> = router {
        "/customer".nest {
            GET("/{id}", accept(MediaType.APPLICATION_JSON), customerRequestHandler::get)
            POST("/", accept(MediaType.APPLICATION_JSON), customerRequestHandler::create)
            DELETE("/{id}", accept(MediaType.APPLICATION_JSON), customerRequestHandler::delete)
        }
        "/customers".nest {
            GET("/", customerRequestHandler::search)
        }
    }
}
