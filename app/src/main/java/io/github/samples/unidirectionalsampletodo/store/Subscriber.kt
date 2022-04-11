package io.github.samples.unidirectionalsampletodo.store

abstract class Subscriber<in T>() {
    abstract fun handle(data: T)
}

abstract class SideEffect : Subscriber<Action>()