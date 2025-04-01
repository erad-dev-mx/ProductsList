package erad.tinyapps.productslist.store.data.repository

import arrow.core.Either
import erad.tinyapps.productslist.store.data.mapper.toNetworkError
import erad.tinyapps.productslist.store.data.remote.ProductsApi
import erad.tinyapps.productslist.store.domain.model.NetworkError
import erad.tinyapps.productslist.store.domain.model.Product
import erad.tinyapps.productslist.store.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productsApi: ProductsApi
) : ProductsRepository {
    override suspend fun getProducts(): Either<NetworkError, List<Product>> {
        return Either.catch {
            productsApi.getProducts()
        }.mapLeft { it.toNetworkError() }
    }
}