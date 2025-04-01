package erad.tinyapps.productslist.store.domain.repository

import arrow.core.Either
import erad.tinyapps.productslist.store.domain.model.NetworkError
import erad.tinyapps.productslist.store.domain.model.Product

interface ProductsRepository {
    suspend fun getProducts(): Either<NetworkError, List<Product>>
}