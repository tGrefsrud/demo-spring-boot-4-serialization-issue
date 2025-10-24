package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Jackson3DeserializationDemoApplication

fun main(args: Array<String>) {
	runApplication<Jackson3DeserializationDemoApplication>(*args)
}
