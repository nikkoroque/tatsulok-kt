package com.example.tatsulokpos.product.data

import com.example.tatsulokpos.product.model.ProductModel

object ProductDao {
    private val productModel: List<ProductModel> = listOf(
        ProductModel(
            id = 1,
            sku = "TSH1",
            name = "Oversized Cotton T-shirt",
            description = "Oversized T-shirt in heavy cotton jersey with a round, rib-trimmed neckline, dropped shoulders and a straight-cut hem.",
            price = 10.00,
            categoryId = 1,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fc8%2F23%2Fc823f897ff0b5eaca9fd1c4488ba01089fc679c4.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 2,
            sku = "TSH2",
            name = "Cotton T-shirt",
            description = "Straight-cut T-shirt in soft cotton jersey with a round, rib-trimmed neckline and gently dropped shoulders.",
            price = 17.00,
            categoryId = 1,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F0d%2Fdb%2F0ddbdf3dd26191bab60e69f5367fbd70bc056819.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bladies_basics_tops_shortsleeve%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 3,
            sku = "T1",
            name = "Sports vest top",
            description = "Sports vest top in DryMove™ functional fabric that helps to wick away moisture from your skin, keeping you comfortably dry while you move.",
            price = 20.00,
            categoryId = 2,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fcb%2Fc7%2Fcbc707325916a7d0b18f2bd1cb478d92c21dbf64.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 4,
            sku = "T2",
            name = "Cropped vest top",
            description = "Cropped, fitted vest top in ribbed cotton jersey with a narrow cut at the top and a racer back.",
            price = 11.00,
            categoryId = 2,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F59%2Fe9%2F59e94d1e09e5169fccb39e68687aa7dcd4627e2a.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 5,
            sku = "PS1",
            name = "Cotton Polo Shirt",
            description = "Relaxed-fit polo shirt in ribbed cotton jersey with a collar, button placket and short sleeves.",
            price = 20.00,
            categoryId = 3,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fe3%2F97%2Fe3975780b65497af0a82eb51681f4769e3a163c6.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5BMEN_TSHIRTSTANKS_POLO%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/main]",
            featuredProduct = true
        ),
        ProductModel(
            id = 6,
            sku = "SSH1",
            name = "Loose Fit Sweatshirt",
            description = "Top in lightweight sweatshirt fabric made from a cotton blend with a soft brushed inside. ",
            price = 30.00,
            categoryId = 4,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Faa%2F98%2Faa9883340e04b4370ad7a3feec55fa7cc0da5c7c.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_hoodiessweatshirts_sweatshirts%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 7,
            sku = "JCK1",
            name = "Regular Fit Bomber Jacket",
            description = "Lightweight bomber jacket in woven fabric with a ribbed stand-up collar and zip down the front. ",
            price = 19.99,
            categoryId = 5,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fed%2F0a%2Fed0a3082635faeaba2ff242ca205280c7cf24599.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 8,
            sku = "SH1",
            name = "Pull-on Shorts",
            description = "Loose-fit shorts in cotton poplin featuring a high, elasticated waist with a small frill trim and diagonal side pockets.",
            price = 34.99,
            categoryId = 6,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F87%2F8d%2F878d34ed2259712826296de05498bc2cc8e9ebe6.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 9,
            sku = "SH2",
            name = "Denim Shorts",
            description = "5-pocket shorts in cotton denim with a slight stretch for good comfort. ",
            price = 30.99,
            categoryId = 6,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F2a%2F9f%2F2a9f12055a473e97060467a609211a0bf39dde8b.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_shorts_denim%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 10,
            sku = "TRS1",
            name = "Slim Fit Cotton chinos",
            description = "Chinos in stretch cotton twill with a zip fly and button, diagonal side pockets and welt back pockets with a button.",
            price = 30.99,
            categoryId = 7,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F79%2F6c%2F796cdecdc61d791a0aad0a52ad401cc0798be506.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 11,
            sku = "TRS2",
            name = "Slim Fit trousers",
            description = "Slim-fit trousers in twill with a concealed hook-and-eye fastener in the waistband and a zip fly. ",
            price = 10.00,
            categoryId = 7,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F9b%2Fce%2F9bce518347964b3c7729a45067fea07fd30a9ff1.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_trousers_dressed%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 12,
            sku = "TRS3",
            name = "Flared jersey trousers",
            description = "Tailored trousers in crêpe jersey featuring a high waist with covered elastication at the back, a zip fly and an extended waistband with a concealed button and hook-and-bar fasteners.",
            price = 17.00,
            categoryId = 7,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F1b%2Fb1%2F1bb1f9f113be3e992e07901bc5e68a0743fedd54.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 13,
            sku = "JN1",
            name = "Wide High Jeans",
            description = "5-pocket jeans in washed cotton denim with a high waist, zip fly and button and wide, straight legs.",
            price = 20.00,
            categoryId = 8,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fe7%2Fe4%2Fe7e46f83cb1d2432430a19f1b969c4ba96c2e405.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bladies_jeans%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 14,
            sku = "JN2",
            name = "Straight Regular Jeans",
            description = "Straight leg and a regular fit from the waist to the hem with a comfortable, looser feel around the whole leg. Regular waist and a zip fly.",
            price = 11.00,
            categoryId = 8,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Ff0%2F63%2Ff063101a844f1143743c01cb6629cbcebf0f6841.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 15,
            sku = "D1",
            name = "Tie-detail open-back dress",
            description = "6pc of our next-level crispy, next-level juicy Chickenjoy fried chicken (choose between Original and Spicy) served with 2 regular sides and 2 fountain drinks.",
            price = 20.00,
            categoryId = 9,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F13%2F19%2F1319edea500ac2b5a990e249a9cd4cc91f1bd4d6.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 16,
            sku = "BL1",
            name = "Slim Fit Blazer",
            description = "Single-breasted jacket in a stretch weave with narrow notch lapels with a decorative buttonhole, a chest pocket, flap front pockets and one inner pocket. ",
            price = 30.00,
            categoryId = 10,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F6f%2F8e%2F6f8e808ac2dce2241dd155631c48729f8f4b43d6.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 17,
            sku = "BL2",
            name = "Fitted blazer",
            description = "Fitted, single-breasted blazer in woven fabric with notch lapels and buttons at the front.",
            price = 19.99,
            categoryId = 10,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F79%2F64%2F7964826616753da074e91cb567077cfc7a05f65f.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 18,
            sku = "SKR1",
            name = "Pleated jersey skirt",
            description = "Short, A-line skirt in heavy, pleated jersey featuring a high waist with an elasticated waistband.",
            price = 34.99,
            categoryId = 11,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F7b%2F27%2F7b27336092f22d7df353670441fbecc97e9419ac.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 19,
            sku = "C1",
            name = "Zip Cardigan",
            description = "A knitted zip cardigan with a slim fit crafted from a soft fabric. It features a round neckline with a collar, and a versatile 2-way zipper.",
            price = 30.99,
            categoryId = 12,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F2a%2F7b%2F2a7b63f6e0d04f23b5b989d6c4dbc9abe654c5a4.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5B%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/fullscreen]",
            featuredProduct = true
        ),
        ProductModel(
            id = 20,
            sku = "SCK1",
            name = "Patterned Socks",
            description = "Socks in a soft, jacquard-knit cotton blend with elasticated tops.",
            price = 30.99,
            categoryId = 13,
            featuredImage = "https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F7f%2F40%2F7f4039ff777c9b2a3caee2abe9e2ed694a75a30d.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_socks%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/main]",
            featuredProduct = true
        )

    )
    fun getProducts(): List<ProductModel> {
        return productModel
    }

}