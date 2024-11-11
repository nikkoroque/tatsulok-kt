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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import com.example.tatsulokpos.product.data.ProductDao.getProducts
import com.example.tatsulokpos.product.model.ProductModel

@Composable
fun Products(selectedCategoryId: Int, onAddToCart: (ProductModel) -> Unit) {
    val filteredProducts = getProducts().filter { it.categoryId == selectedCategoryId }
    val selectedCategoryName = getCategories().find { it.id == selectedCategoryId }?.name ?: "Featured Products"
    Text(
        text = selectedCategoryName,
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier
            .fillMaxWidth()
    )
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
        columns = GridCells.Fixed(4) // Set the number of columns to 4
    ) {
        items(filteredProducts.size, key = { index -> filteredProducts[index].id }) { index ->
            ProductCard(index, filteredProducts, onAddToCart = onAddToCart)
        }
    }
}


@Composable
fun ProductCard(index: Int, products: List<ProductModel>, onAddToCart: (ProductModel) -> Unit) {
    val product = products[index]

    Box(modifier = Modifier.padding(vertical = 10.dp).padding(start = 10.dp, end = 10.dp)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFFEFEFA))
                .width(250.dp)
                .height(120.dp)
                .clickable { onAddToCart(product) }
                .padding(vertical = 5.dp, horizontal = 5.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = product.featuredImage,
                contentDescription = product.sku,
                modifier = Modifier
                    .width(150.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = product.name,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )
        }
    }
}