package com.example.reactivedemo.live

import io.netty.channel.nio.NioEventLoopGroup
import mu.KotlinLogging
import org.springframework.http.client.Netty4ClientHttpRequestFactory
import org.springframework.util.StopWatch
import org.springframework.web.client.AsyncRestTemplate
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

private val log = KotlinLogging.logger {}
private val es = Executors.newFixedThreadPool(100)

class LoadTest(
) {
    private val BASE_URL: String = "http://localhost:8080"

    private val restTemplate = RestTemplate()

    fun fetchApi() {
        for (i in 0..100) {
            es.execute {
                val stopWatch = StopWatch()

                stopWatch.start()
                val response = restTemplate.getForObject("$BASE_URL/nonblock?=idx=$i", String::class.java)
                stopWatch.stop()

                log.info { "response=$response, stopWatch=${stopWatch.totalTimeSeconds}" }
            }
        }
    }
}

fun main(args: Array<String>) {
    val loadTest = LoadTest()
    val stopWatch = StopWatch()

    stopWatch.start()
    loadTest.fetchApi()

    es.shutdown()
    es.awaitTermination(1000, TimeUnit.SECONDS)

    stopWatch.stop()
    log.info { "Total stop watch ${stopWatch.totalTimeSeconds}" }
}