package erad.tinyapps.productslist.store.data.mapper

import coil3.network.HttpException
import erad.tinyapps.productslist.store.domain.model.ApiError
import erad.tinyapps.productslist.store.domain.model.NetworkError
import java.io.IOException

fun Throwable.toNetworkError(): NetworkError {
    val error = when (this) {
        is IOException -> ApiError.NetworkError
        is HttpException -> ApiError.UnknownResponse
        else -> ApiError.UnknownError
    }
    return NetworkError(
        error = error,
        t = this
    )
}