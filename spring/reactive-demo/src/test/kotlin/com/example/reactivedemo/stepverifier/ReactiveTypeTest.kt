package com.example.reactivedemo.stepverifier

import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import reactor.test.StepVerifier
import java.time.Duration

class ReactiveTypeTest {

    @Test
    fun join() {
        val peopleFlux = Flux.just("noah", "kevin", "elly")
        StepVerifier.create(peopleFlux)
            .expectNext("noah")
            .expectNext("kevin")
            .expectNext("elly")
            .verifyComplete()   // people이 완전히 같은지 확인
    }

    @Test
    fun fromIterable() {
        val people = listOf("noah", "kevin", "elly")
        val peopleFlux = Flux.fromIterable(people)
        StepVerifier.create(peopleFlux)
            .expectNext("noah")
            .expectNext("kevin")
            .expectNext("elly")
            .verifyComplete()
    }

    @Test
    fun range() {
        val people = Flux.range(1, 3);
        StepVerifier.create(people)
            .expectNext(1)
            .expectNext(2)
            .expectNext(3)
            .verifyComplete();
    }

    @Test
    fun interval() {
        val people = Flux.interval(Duration.ofSeconds(1))
            .take(3); // 값을 제한하지 않으면 무한정 실행됨

        StepVerifier.create(people)
            .expectNext(0L) // 0부터 시작함
            .expectNext(1L)
            .expectNext(2L)
            .verifyComplete();
    }

    class Profile(val name: String, val age: String)

    @Test
    fun map() {
        val profileFlux: Flux<Profile> = Flux
            .just("noah 25", "kevin 27", "elly 20")
            .map {
                val split = it.split("\\s").toTypedArray()
                Profile(split[0], split[1])
            }
        StepVerifier.create(profileFlux)
            .expectNext(Profile("noah", "25"))
            .expectNext(Profile("kevin", "27"))
            .expectNext(Profile("elly", "20"))
            .verifyComplete()
    }

    @Test
    fun flatmap() {
        val profileFlux = Flux
            .just("noah 25", "kevin 27", "elly 20")
            .flatMap {
                Mono.just(it)
                    .map {
                        val split = it.split("\\s")
                        Profile(split[0], split[1])
                    }
                .subscribeOn(Schedulers.parallel())
            }

        val profiles = listOf(
            Profile("noah", "25"),
            Profile("kevin", "27"),
            Profile("elly", "20")
        )
        StepVerifier.create(profileFlux)
            .expectNextMatches { profiles.contains(it) }
            .expectNextMatches { profiles.contains(it) }
            .expectNextMatches { profiles.contains(it) }
            .verifyComplete()
    }
}