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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tatsulokpos.product.data.CategoryDao.getCategories

@Composable
fun Categories(onCategorySelected: (Int) -> Unit) {
    Text(
        text = "Categories",
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier
            .fillMaxWidth()
    )
    LazyRow {
        items(getCategories().size, key = { index -> getCategories()[index].id }) { index ->
            CategoryCard(index, onCategorySelected)
        }
    }
}

@Composable
fun CategoryCard(index: Int, onCategorySelected: (Int) -> Unit) {
    val card = getCategories()[index]
    val isLastItem = index == getCategories().size - 1
    val paddingEnd = if (isLastItem) 16.dp else 0.dp

    Box(modifier = Modifier.padding(start = 10.dp, end = paddingEnd)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFFEFEFA))
                .width(150.dp)
                .height(120.dp)
                .clickable { onCategorySelected(card.id) }
                .padding(vertical = 5.dp, horizontal = 5.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = card.featuredImage,
                contentDescription = card.name,
                modifier = Modifier
                    .width(150.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.name,
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }
    }
}