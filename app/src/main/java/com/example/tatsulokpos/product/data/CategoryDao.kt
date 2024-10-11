package com.example.tatsulokpos.product.data

import com.example.tatsulokpos.product.model.CategoryModel

object CategoryDao {
    private val categoryModel: List<CategoryModel> = listOf(
        CategoryModel(
            id = 1,
            name = "Meal Deals",
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F79%2F79c02d04bac9410181a4b6c7cad8d71b.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D410896b3b7b2c930b59cf91ede0d42e1&w=380&q=75"
        ),
        CategoryModel(
            id = 2,
            name = "Chickenjoy Fried Chicken",
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F59%2F59b6b0112a864b9083ac1caa97b0df59.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D386f92d41401d00c53a440cfac1983b5&w=380&q=75"
        ),
        CategoryModel(
            id = 3,
            name = "Perfect Pairs",
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F13%2F137fcb923bfa4d1f972aa8031fd13195.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D00b110bc02320e145b32a946911751e5&w=380&q=75"
        ),
        CategoryModel(
            id = 4,
            name = "Chicken Sandwiches",
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2Fca%2Fcac1c5ffd1744ffc866b36e63e0c0872.png%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D2011b47e9ae97e755cadcca21afaa1eb&w=380&q=75"
        ),
        CategoryModel(
            id = 5,
            name = "Chicken Tenders",
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2Fb0%2Fb04b7d409c114fa8b7a1bcc7900cbc1b.png%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D4f3d77050dd3ac6c51dc4631b1f9a261&w=380&q=75"
        ),
        CategoryModel(
            id = 6,
            name = "Burgers",
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Fjollibee-prod-media.s3.us-west-2.amazonaws.com%2FJB_US_CAN_OLO_Prod_Image_Angus_Cheeseburger_84b1ee89f2.jpg&w=380&q=75"
        ),
        CategoryModel(
            id = 7,
            name = "Jolly Spaghetti",
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F38%2F384cc52ac0884b7aabdc41b8bde5584b.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D34eab722154af5ef146926a8539be5a9&w=380&q=75"
        ),
        CategoryModel(
            id = 8,
            name = "Palabok Fiesta",
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2Fdb%2Fdbe7150e4e66424e93ca644329a911c9.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D3ae50c138abf3e488df4d6da6860148a&w=380&q=75"
        ),
        CategoryModel(
            id = 9,
            name = "Burger Steak",
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2Ffc%2Ffcb2c64b583d49579de4b4fbed68be19.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3Ded357c4de87107cfcdbb9329fe3251cc&w=380&q=75"
        ),
        CategoryModel(
            id = 10,
            name = "Family Meals",
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F01%2F016baedae1144913ba7965a5d2b2fa0e.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3Dabc2acca2e08c88c98a1ef95ef289875&w=380&q=75"
        ),
        CategoryModel(
            id = 11,
            name = "Sides",
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F89%2F89bb67ed7e6c420bbb41963bb9041072.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3Deb18c056ee535f3ddebf87a8b2e4f84f&w=380&q=75"
        ),
        CategoryModel(
            id = 12,
            name = "Specialty Drinks",
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F49%2F4988591ce4ff4f38a9eae36dde2a5056.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D2063dc72cdb8a1f5bf1a4abdbda97f8d&w=380&q=75"
        ),
        CategoryModel(
            id = 13,
            name = "Desserts",
            featuredImage = "https://www.jollibeefoods.com/_next/image?url=https%3A%2F%2Folo-images-live.imgix.net%2F4e%2F4e4d92921a884550b082cec289df5ab1.jpg%3Fauto%3Dformat%252Ccompress%26q%3D60%26cs%3Dtinysrgb%26w%3D1200%26h%3D800%26fit%3Dfill%26fm%3Dpng32%26bg%3Dtransparent%26s%3D24643e34fe412e480afbe7401f54e906&w=380&q=75"
        )
    )
    fun getCategories(): List<CategoryModel> {
        return categoryModel
    }

}