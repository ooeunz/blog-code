package com.example.reactivedemo.live

import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

class PubSub

fun main(args: Array<String>) {
    val publisher = object : Publisher<Int> {
        val iter = listOf(1, 2, 3, 4, 5).iterator()

        override fun subscribe(s: Subscriber<in Int>) {
            s.onSubscribe(
                object : Subscription {
                    override fun request(n: Long) {
                        try {
                            var idx = 0
                            while (idx++ < n) {
                                if (iter.hasNext()) {
                                    s.onNext(iter.next())
                                    idx++
                                } else {
                                    s.onComplete()
                                }
                            }
                        } catch (e: Exception) {
                            s.onError(e)
                        }
                    }
                    override fun cancel() {}
                }
            )
        }
    }

    val subscriber = object : Subscriber<Int> {
        lateinit var subscription: Subscription

        override fun onSubscribe(s: Subscription) {
            println("onSubscribe()")
            subscription = s
            subscription.request(1)
        }

        override fun onNext(t: Int) {
            println("onNext(): $t")
            subscription.request(1)
        }

        override fun onError(t: Throwable) {
            println("onError()")
            println(t.message)
        }

        override fun onComplete() {
            println("onComplete()")
        }
    }

    publisher.subscribe(subscriber)
}

