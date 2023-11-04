package com.wahyouwebid.valorantapp.features.agent.presentation.agents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.wahyouwebid.valorantapp.common.components.ErrorText
import com.wahyouwebid.valorantapp.common.components.SearchBar

@Composable
fun AgentsScreen(
    viewModel: AgentsViewModel = hiltViewModel(),
    navigateToAgentDetail: (String) -> Unit,
) {

    val state = viewModel.state.value
    val searchQuery = viewModel.searchQuery.value

    Box {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        ) {
            SearchBar(
                searchText = searchQuery,
                placeholderText = "Search Agent",
                onSearchTextChanged = { value ->
                    viewModel.searchAgent(value)
                },
                onClearClick = {
                    viewModel.clearSearchQuery()
                },
                backgroundColor = Color.White
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                contentPadding = PaddingValues(12.dp)
            ) {
                items(state.agents){ agentItem ->
                    AgentItem(
                        agent = agentItem,
                        onItemClick = {
                            navigateToAgentDetail.invoke(it)
                        }
                    )
                }
            }
        }

        if (state.error.isNotBlank()) ErrorText(state.error, Modifier.align(Alignment.Center))

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color.White
            )
        }
    }
}