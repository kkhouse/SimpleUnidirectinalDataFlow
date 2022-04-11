package io.github.samples.unidirectionalsampletodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.samples.unidirectionalsampletodo.store.AppStore
import io.github.samples.unidirectionalsampletodo.store.UiState
import io.github.samples.unidirectionalsampletodo.ui.theme.UnidirectionalSampleTodoTheme
import io.github.samples.unidirectionalsampletodo.view.ContentListControllerView
import io.github.samples.unidirectionalsampletodo.view.userEvent.ContentListEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val controllerView = ContentListControllerView(
                store = AppStore.withSideEffect()
            )
            val uiState by controllerView.uiState.collectAsState(initial = UiState.Show)
            val contents by controllerView.contents.collectAsState(initial = emptyList())

            UnidirectionalSampleTodoTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    OutlinedButton(onClick = {
                        controllerView.onEvent(ContentListEvent.UpdateTodoList)
                    }) {
                        Text(text = "random update")
                    }
                    Spacer(
                        modifier = Modifier.fillMaxWidth().size(24.dp)
                    )
                    if (uiState == UiState.Loading) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    } else {
                        LazyColumn {
                            if (contents.isEmpty()) {
                                item {
                                    Text("empty list")
                                }
                            }
                            items(contents) { content ->
                                Text(text = "${content.text} :  ${content.id}")
                            }
                        }
                    }
                }
            }
        }
    }
}