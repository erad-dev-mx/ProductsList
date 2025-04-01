package erad.tinyapps.productslist.store.presentation.products_screen

import erad.tinyapps.productslist.store.domain.model.Product

data class ProductsViewState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)