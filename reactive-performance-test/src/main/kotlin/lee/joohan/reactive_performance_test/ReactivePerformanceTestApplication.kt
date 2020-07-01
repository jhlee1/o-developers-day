package lee.joohan.reactive_performance_test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactivePerformanceTestApplication

fun main(args: Array<String>) {
	runApplication<ReactivePerformanceTestApplication>(*args)
}
