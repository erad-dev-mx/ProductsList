package erad.tinyapps.productslist.store.presentation.products_screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import erad.tinyapps.productslist.store.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import erad.tinyapps.productslist.store.presentation.util.sendEvent
import erad.tinyapps.productslist.util.Event
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsRepository: ProductsRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ProductsViewState())
    val state = _state.asStateFlow()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            productsRepository.getProducts().onRight { products ->
                _state.update { it.copy(products = products) }
            }.onLeft { e ->
                _state.update {
                    it.copy(
                        error = e.error.message
                    )
                }
                sendEvent(Event.Toast(e.error.message))
            }

            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}