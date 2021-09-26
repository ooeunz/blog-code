package com.example.reactivedemo.stepverifier

import org.junit.jupiter.api.Test
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import java.time.Duration

class WebClientTest {

    class Fruit(val name: String)

    @Test
    fun get() {
        val id = "apple"
        val fruit = WebClient.create()
            .get()
            .uri("localhost:8080/fruits/{id}", id) // 요청을 정의함
            .retrieve()  // 요청을 실행함
            .bodyToMono(Fruit::class.java)   // 응답 몸체의 payload를 Mono 형태로 추출함

        fruit
            .timeout(Duration.ofSeconds(1))  // 1초 이상 걸리게 되면 subscribe에 두번재 인자로 지정된 에러 핸들러가 실행됨
            .subscribe { println(it) }
    }

    @Test
    fun post() {
        val fruitMono = Mono.just(Fruit("파인애플"))
        val fruit = WebClient.create()
            .post()
            .uri("localhost:8080/fruits")
            .body(fruitMono, Fruit::class.java)
            .retrieve()
            .bodyToMono(Fruit::class.java)

        fruit.subscribe { println(it) }
    }

    @Test
    fun voidPost() {
        val fruitMono = Fruit("파인애플")
        val fruit = WebClient.create()
            .post()
            .uri("localhost:8080/fruits")
            .bodyValue(fruitMono)
            .retrieve()
            .bodyToMono(Void::class.java)

        fruit.subscribe { println(it) }
    }
}