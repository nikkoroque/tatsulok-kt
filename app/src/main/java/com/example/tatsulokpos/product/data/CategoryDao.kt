package com.example.tatsulokpos.product.data

import com.example.tatsulokpos.product.model.CategoryModel

object CategoryDao {
    private val categoryModel: List<CategoryModel> = listOf(
        CategoryModel(
            id = 1,
            name = "T-shirts",
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F99%2F4b%2F994b4715f355becf0debdb453cc2ac3f80f6fa56.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]"
        ),
        CategoryModel(
            id = 2,
            name = "Tank Tops",
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F22%2F7d%2F227d721b6737ebcda03bd336e26fc5c4efacfa75.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]"
        ),
        CategoryModel(
            id = 3,
            name = "Polo Shirts",
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Ffa%2F0b%2Ffa0bf757bd60fd5be16bf3d6c86711038d06354a.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]"
        ),
        CategoryModel(
            id = 4,
            name = "Sweatshirts",
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F75%2F0c%2F750cc44b179769a6c212f0bd132be814cfe76567.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/main]"
        ),
        CategoryModel(
            id = 5,
            name = "Jackets",
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F37%2F1e%2F371e809a584dbbe201146e8374f5e5e866e13190.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/main]"
        ),
        CategoryModel(
            id = 6,
            name = "Shorts",
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Ffa%2F97%2Ffa97611fcbc9a04eb67e7589b42516440b0a01d6.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]"
        ),
        CategoryModel(
            id = 7,
            name = "Trousers",
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F9b%2Fce%2F9bce518347964b3c7729a45067fea07fd30a9ff1.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_trousers_dressed%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]"
        ),
        CategoryModel(
            id = 8,
            name = "Jeans",
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F19%2F76%2F197605aec5741ec2b504b8aff5c8049c76f2be72.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_jeans_loose%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]"
        ),
        CategoryModel(
            id = 9,
            name = "Dresses",
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F94%2Fcf%2F94cf5e2b099feddc5e4ed5ec0d90703b4665edb4.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]"
        ),
        CategoryModel(
            id = 10,
            name = "Blazers",
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F72%2F14%2F721478188d346b2a0f0c1dd4ec0528229f879b61.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]"
        ),
        CategoryModel(
            id = 11,
            name = "Skirts",
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F83%2F1b%2F831b9ef34ca733cb725a005f71b56e05a8101893.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]"
        ),
        CategoryModel(
            id = 12,
            name = "Cardigans",
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F34%2F84%2F3484db453febabd2ced82596d705b76da3d2692c.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]"
        ),
        CategoryModel(
            id = 13,
            name = "Socks",
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=format%5Bwebp%5D%2Cquality%5B79%5D%2Csource%5B%2Fe8%2Fdb%2Fe8dbc4be90eab4151ab14b5ecbfee7359d6cc0fb.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVEDETAIL%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url%5Bfile%3A%2Fproduct%2Fmain%5D"
        )
    )
    fun getCategories(): List<CategoryModel> {
        return categoryModel
    }

}