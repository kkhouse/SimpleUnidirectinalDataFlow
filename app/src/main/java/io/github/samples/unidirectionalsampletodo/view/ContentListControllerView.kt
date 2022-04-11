package io.github.samples.unidirectionalsampletodo.view

import io.github.samples.unidirectionalsampletodo.store.GenerateAction
import io.github.samples.unidirectionalsampletodo.store.Store
import io.github.samples.unidirectionalsampletodo.store.UiState
import io.github.samples.unidirectionalsampletodo.view.userEvent.ContentListEvent
import io.github.samples.unidirectionalsampletodo.view.userEvent.UserEvent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * UIEventからアクションを生成。storeへ伝達.
 * store側で更新されたstateをViewに反映できる形で取得し公開。
 *
 */
class ContentListControllerView(
    store: Store
) : ControllerView(store) {

    private var _uiState = MutableStateFlow(UiState.Show)
    val uiState = _uiState
    private var _todos = MutableStateFlow(store.state.value.contents)
    val contents = _todos

    init {
        GlobalScope.launch {
            store.state.collect {
                _uiState.value = it.uiState
                _todos.value = it.contents
            }
        }
    }

    override fun onEvent(userEvent: UserEvent) {
        when(userEvent) {
            is ContentListEvent.UpdateTodoList -> store.dispatch(GenerateAction.GenerateContent())
        }
    }
}