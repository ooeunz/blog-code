package com.example.reactivedemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.async.DeferredResult
import reactor.core.publisher.Mono
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

@SpringBootApplication
class ReactiveDemoApplication

fun main(args: Array<String>) {
    runApplication<ReactiveDemoApplication>(*args)
}

@RestController
class DemoControler {
    val es = Executors.newFixedThreadPool(100)

    @GetMapping("/block")
    fun block(idx: Int): String {
        println("/block idx:=$idx")
        val future = es.submit<String>{ slowThread(idx) }
        return future.get()
    }

    @GetMapping("/nonblock")
    fun nonblock(idx: Int): DeferredResult<String> {
        val def = DeferredResult<String>()
        es.submit {
            val slowResult = slowThread(idx)
            def.setResult(slowResult)
        }
        return def
    }

    @GetMapping("/modern")
    fun modernNonBlock(idx: Int): CompletableFuture<String> {
        return CompletableFuture.supplyAsync { slowThread(idx) }
    }

    private fun slowThread(idx: Int): String {
        Thread.sleep(2000L);
        return "SLOW-$idx"
    }

    @GetMapping("/reactive")
    fun reactive(): Mono<String> {
        return Mono.just("This is reactive")
    }
}
