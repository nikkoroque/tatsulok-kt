package com.example.tatsulokpos.product.data

import com.example.tatsulokpos.product.model.ProductModel

object ProductDao {
    private val productModel: List<ProductModel> = listOf(
        ProductModel(
            id = 1,
            sku = "M1",
            name = "Chicken Sandwich and Pie Meal Deal",
            description = "Our Original or Spicy Chicken Sandwich served with regular Jolly Crispy Fries, a fountain drink, and a dessert pie.",
            price = 10.00,
            categoryId = 1,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F79%2F79c02d04bac9410181a4b6c7cad8d71b.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D410896b3b7b2c930b59cf91ede0d42e1&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 2,
            sku = "M2",
            name = "2 Chicken Sandwiches Meal Deal",
            description = "2 Original or Spicy Chicken Sandwiches served with 2 regular Jolly Crispy Fries and 2 fountain drinks.",
            price = 17.00,
            categoryId = 1,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F25%2F25cc363e70134a948e6f455874c2050f.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D988412fbe0d9d38c7ef8983e23913244&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 3,
            sku = "M3",
            name = "4pc Chicken Sandwich Snack Pack",
            description = "4 of our Original or Spicy Chicken Sandwiches.",
            price = 20.00,
            categoryId = 1,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F70%2F70b224a48b664421a02bc6775ce07844.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D236952ecd60b2b7a6bacceaeab1c39e7&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 4,
            sku = "M4",
            name = "2pc Chickenjoy Meal Deal",
            description = "2pc of our next-level crispy, next-level juicy Chickenjoy fried chicken (choose between Original and Spicy) served with a regular side, fountain drink, and Peach Mango Pie.",
            price = 11.00,
            categoryId = 1,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F9e%2F9ebf1f05793d4189bddc73e7cfb2b764.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3Df78586a28f12b89ebf243ea28744c925&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 5,
            sku = "M5",
            name = "6pc Chickenjoy Meal Deal",
            description = "6pc of our next-level crispy, next-level juicy Chickenjoy fried chicken (choose between Original and Spicy) served with 2 regular sides and 2 fountain drinks.",
            price = 20.00,
            categoryId = 1,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F01%2F016baedae1144913ba7965a5d2b2fa0e.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3Dabc2acca2e08c88c98a1ef95ef289875&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 6,
            sku = "M6",
            name = "10pc Chickenjoy Meal Deal",
            description = "10pc of our next-level crispy, next-level juicy Chickenjoy fried chicken (5 legs, 5 thighs, Choose between Original or Spicy) served with 3 pies.",
            price = 30.00,
            categoryId = 1,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2Fb0%2Fb00272f07ae449c8bc563c1eb76b11af.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D9724556cd7a93a2663a34667c5e18442&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 7,
            sku = "BA",
            name = "Bucket Treat A",
            description = "6pc of our next-level crispy, next-level juicy Chickenjoy fried chicken (3 legs, 3 thighs, Choose between Original or Spicy) served with any 2 sides.",
            price = 19.99,
            categoryId = 2,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2Fc3%2Fc3c83af6cf0142598b844e81fdcd093e.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3Dbc393a3b18b82abfd5084ec5e222adea&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 8,
            sku = "BB",
            name = "Bucket Treat B",
            description = "6pc of our next-level crispy, next-level juicy Chickenjoy fried chicken (3 legs, 3 thighs, Choose between Original or Spicy) served with a Jolly Spaghetti Family Pack and 3 pies.",
            price = 34.99,
            categoryId = 2,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F0b%2F0b1ad2284f6344119d7b61874a34ea0e.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3Dbc15e92b8a74d869197aecd88eb8bbdd&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 9,
            sku = "BC",
            name = "Bucket Treat C",
            description = "10pc of our next-level crispy, next-level juicy Chickenjoy fried chicken (5 legs, 5 thighs, Choose between Original or Spicy) served with any 3 sides.",
            price = 30.99,
            categoryId = 2,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F14%2F144eba6221724023aa0dc4e5d55cff6b.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D96abc3d4e0d5dda09d34077ca1ca36a7&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 10,
            sku = "BD",
            name = "Bucket Treat D",
            description = "10pc of our next-level crispy, next-level juicy Chickenjoy fried chicken (5 legs, 5 thighs, Choose between Original or Spicy) served with any 3 sides.",
            price = 30.99,
            categoryId = 2,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F14%2F144eba6221724023aa0dc4e5d55cff6b.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D96abc3d4e0d5dda09d34077ca1ca36a7&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 11,
            sku = "M1",
            name = "Chicken Sandwich and Pie Meal Deal",
            description = "Our Original or Spicy Chicken Sandwich served with regular Jolly Crispy Fries, a fountain drink, and a dessert pie.",
            price = 10.00,
            categoryId = 1,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F79%2F79c02d04bac9410181a4b6c7cad8d71b.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D410896b3b7b2c930b59cf91ede0d42e1&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 12,
            sku = "M2",
            name = "2 Chicken Sandwiches Meal Deal",
            description = "2 Original or Spicy Chicken Sandwiches served with 2 regular Jolly Crispy Fries and 2 fountain drinks.",
            price = 17.00,
            categoryId = 1,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F25%2F25cc363e70134a948e6f455874c2050f.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D988412fbe0d9d38c7ef8983e23913244&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 13,
            sku = "M3",
            name = "4pc Chicken Sandwich Snack Pack",
            description = "4 of our Original or Spicy Chicken Sandwiches.",
            price = 20.00,
            categoryId = 1,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F70%2F70b224a48b664421a02bc6775ce07844.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D236952ecd60b2b7a6bacceaeab1c39e7&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 14,
            sku = "M4",
            name = "2pc Chickenjoy Meal Deal",
            description = "2pc of our next-level crispy, next-level juicy Chickenjoy fried chicken (choose between Original and Spicy) served with a regular side, fountain drink, and Peach Mango Pie.",
            price = 11.00,
            categoryId = 1,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F9e%2F9ebf1f05793d4189bddc73e7cfb2b764.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3Df78586a28f12b89ebf243ea28744c925&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 15,
            sku = "M5",
            name = "6pc Chickenjoy Meal Deal",
            description = "6pc of our next-level crispy, next-level juicy Chickenjoy fried chicken (choose between Original and Spicy) served with 2 regular sides and 2 fountain drinks.",
            price = 20.00,
            categoryId = 1,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F01%2F016baedae1144913ba7965a5d2b2fa0e.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3Dabc2acca2e08c88c98a1ef95ef289875&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 16,
            sku = "M6",
            name = "10pc Chickenjoy Meal Deal",
            description = "10pc of our next-level crispy, next-level juicy Chickenjoy fried chicken (5 legs, 5 thighs, Choose between Original or Spicy) served with 3 pies.",
            price = 30.00,
            categoryId = 1,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2Fb0%2Fb00272f07ae449c8bc563c1eb76b11af.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D9724556cd7a93a2663a34667c5e18442&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 17,
            sku = "BA",
            name = "Bucket Treat A",
            description = "6pc of our next-level crispy, next-level juicy Chickenjoy fried chicken (3 legs, 3 thighs, Choose between Original or Spicy) served with any 2 sides.",
            price = 19.99,
            categoryId = 2,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2Fc3%2Fc3c83af6cf0142598b844e81fdcd093e.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3Dbc393a3b18b82abfd5084ec5e222adea&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 18,
            sku = "BB",
            name = "Bucket Treat B",
            description = "6pc of our next-level crispy, next-level juicy Chickenjoy fried chicken (3 legs, 3 thighs, Choose between Original or Spicy) served with a Jolly Spaghetti Family Pack and 3 pies.",
            price = 34.99,
            categoryId = 2,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F0b%2F0b1ad2284f6344119d7b61874a34ea0e.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3Dbc15e92b8a74d869197aecd88eb8bbdd&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 19,
            sku = "BC",
            name = "Bucket Treat C",
            description = "10pc of our next-level crispy, next-level juicy Chickenjoy fried chicken (5 legs, 5 thighs, Choose between Original or Spicy) served with any 3 sides.",
            price = 30.99,
            categoryId = 2,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F14%2F144eba6221724023aa0dc4e5d55cff6b.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D96abc3d4e0d5dda09d34077ca1ca36a7&w=380&q=75",
            featuredProduct = true
        ),
        ProductModel(
            id = 20,
            sku = "BD",
            name = "Bucket Treat D",
            description = "10pc of our next-level crispy, next-level juicy Chickenjoy fried chicken (5 legs, 5 thighs, Choose between Original or Spicy) served with any 3 sides.",
            price = 30.99,
            categoryId = 2,
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F14%2F144eba6221724023aa0dc4e5d55cff6b.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D96abc3d4e0d5dda09d34077ca1ca36a7&w=380&q=75",
            featuredProduct = true
        )

    )
    fun getProducts(): List<ProductModel> {
        return productModel
    }

}