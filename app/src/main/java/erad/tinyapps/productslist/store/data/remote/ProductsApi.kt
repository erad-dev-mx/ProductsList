package erad.tinyapps.productslist.store.data.remote

import erad.tinyapps.productslist.store.domain.model.Product
import retrofit2.http.GET

interface ProductsApi {

    @GET("products")
    suspend fun getProducts(): List<Product>
}