package io.github.samples.unidirectionalsampletodo.view.userEvent

sealed class UserEvent

sealed class ContentListEvent: UserEvent() {
    object UpdateTodoList: ContentListEvent()
}
