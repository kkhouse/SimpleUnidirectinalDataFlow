package io.github.samples.unidirectionalsampletodo.side_effect.handler

import io.github.samples.unidirectionalsampletodo.store.Action
import io.github.samples.unidirectionalsampletodo.store.GenerateAction
import io.github.samples.unidirectionalsampletodo.store.LoadAction
import io.github.samples.unidirectionalsampletodo.store.Content
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object GenerateHandler: ActionHandler<GenerateAction> {

    override fun handle(action: GenerateAction, actionDispatcher: (Action) -> Unit) {
        when(action) {
            is GenerateAction.GenerateContent -> {
                GlobalScope.launch {
                    delay(5000) // 重い処理
                    actionDispatcher.invoke(LoadAction.LoadContent(generateMockContent()))
                }
            }
        }
    }

    private fun generateMockContent(): List<Content> {
        return listOf(Content(1, "Hello"), Content(2, "World"))
    }
}