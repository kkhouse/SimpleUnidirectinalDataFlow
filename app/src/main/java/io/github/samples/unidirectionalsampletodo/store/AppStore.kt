package io.github.samples.unidirectionalsampletodo.store

import io.github.samples.unidirectionalsampletodo.side_effect.SideEffectImpl

object AppStore :Store(null){

    fun withSideEffect(): Store {
        SideEffectImpl(this)
        return this
    }
}