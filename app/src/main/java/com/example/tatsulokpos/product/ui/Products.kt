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
import androidx.compose.foundation.lazy.grid.items
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
import com.example.tatsulokpos.product.model.ProductModel
import com.example.tatsulokpos.product.viewmodel.ProductViewModel

@Composable
fun Products(
    selectedCategoryId: Int,
    onAddToCart: (ProductModel) -> Unit,
    viewModel: ProductViewModel = viewModel() // Inject ProductViewModel
) {
    // Observe products from the ViewModel's state
    val products by viewModel.products.collectAsState()

    // Fetch products when this composable is loaded
    LaunchedEffect(Unit) {
        viewModel.fetchAllProducts()
    }

    // Filter products based on selected category
    val filteredProducts = products.filter { it.category_id == selectedCategoryId }

    // Get category name or fallback to default
    val selectedCategoryName = "Products" // Replace with dynamic logic if needed

    // Category header
    Text(
        text = selectedCategoryName,
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier.fillMaxWidth()
    )

    // Product grid
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        columns = GridCells.Fixed(4) // Set the number of columns to 4
    ) {
        items(filteredProducts, key = { it.product_id }) { product ->
            ProductCard(product, onAddToCart)
        }
    }
}

@Composable
fun ProductCard(
    product: ProductModel,
    onAddToCart: (ProductModel) -> Unit
) {
    // Check if product quantity is 0
    val isProductDisabled = product.quantity == 0

    Box(modifier = Modifier
        .padding(vertical = 10.dp)
        .padding(start = 10.dp, end = 10.dp)) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isProductDisabled) Color.Gray else Color(0xFFFEFEFA)) // Change color for out-of-stock
                .width(250.dp)
                .height(120.dp)
                .clickable(enabled = !isProductDisabled) {
                    if (!isProductDisabled) {
                        onAddToCart(product)
                    }
                }
                .padding(vertical = 5.dp, horizontal = 5.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = product.img, // Assuming `img` field holds the image URL
                contentDescription = product.name,
                modifier = Modifier
                    .width(150.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(5.dp))
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = product.name,
                color = if (isProductDisabled) Color.DarkGray else Color.Black, // Dim the text for out-of-stock
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )

            if (isProductDisabled) {
                Text(
                    text = "Out of Stock",
                    color = Color.Red,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}
