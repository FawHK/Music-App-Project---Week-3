package de.syntax_institut.musicapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.syntax_institut.musicapp.data.SearchQuery
import de.syntax_institut.musicapp.data.searchQueries



@Composable
fun SearchView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(top = 24.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Search") },
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
        )
    }
    Spacer(modifier = modifier.height(16.dp))
    QueryGrid(queries = searchQueries)
}



@Composable
fun QueryView(query: SearchQuery, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = query.color
        ),
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = query.query,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            modifier = modifier
                .fillMaxWidth()
                .padding(40.dp)

        )
    }
}

@Composable
fun QueryGrid(queries: List<SearchQuery>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .padding(top = 150.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
    ) {
        items(queries) { query ->
            QueryView(query = query)
        }
    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun SearchViewPreview() {
//    SearchView()
//}