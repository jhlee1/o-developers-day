package lee.joohan.restmvcperformancetest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RestMvcPerformanceTestApplication

fun main(args: Array<String>) {
	runApplication<RestMvcPerformanceTestApplication>(*args)
}
