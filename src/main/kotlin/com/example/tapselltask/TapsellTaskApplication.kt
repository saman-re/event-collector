package com.example.tapselltask

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class TapsellTaskApplication

fun main(args: Array<String>) {
    SpringApplication.run(TapsellTaskApplication::class.java,*args)
}
