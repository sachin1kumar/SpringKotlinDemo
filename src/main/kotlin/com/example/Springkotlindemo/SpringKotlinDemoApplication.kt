package com.example.Springkotlindemo

import com.example.Springkotlindemo.domain.Employee
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SpringKotlinDemoApplication

fun main(args: Array<String>) {
	runApplication<SpringKotlinDemoApplication>(*args)
}
