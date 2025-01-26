package com.example.tatsulokpos.product.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tatsulokpos.product.model.CategoryModel
import com.example.tatsulokpos.product.viewmodel.CategoryViewModel

@Composable
fun Categories(
    onCategorySelected: (Int) -> Unit,
    viewModel: CategoryViewModel = viewModel() // Inject CategoryViewModel
) {
    // Observe categories from the ViewModel's state
    val categories by viewModel.categories.collectAsState()

    // Fetch categories when this composable is loaded
    LaunchedEffect(Unit) {
        viewModel.fetchCategories()
    }

    // Category header
    Text(
        text = "Categories",
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier.fillMaxWidth()
    )

    // Category row
    LazyRow {
        items(categories, key = { it.category_id }) { category ->
            CategoryCard(category, onCategorySelected)
        }
    }
}

@Composable
fun CategoryCard(
    category: CategoryModel,
    onCategorySelected: (Int) -> Unit
) {
    Box(modifier = Modifier.padding(start = 10.dp, end = 10.dp)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Black)
                .width(150.dp)
                .height(70.dp)
                .clickable { onCategorySelected(category.category_id) }
                .padding(vertical = 5.dp, horizontal = 5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            AsyncImage(
//                model = category.description, // Replace with appropriate image URL if available
//                contentDescription = category.name,
//                modifier = Modifier
//                    .width(150.dp)
//                    .height(80.dp)
//                    .clip(RoundedCornerShape(5.dp))
//            )
//            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = category.name,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }
    }
}
