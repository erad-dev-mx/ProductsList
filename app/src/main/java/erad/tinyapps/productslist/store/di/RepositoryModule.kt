package erad.tinyapps.productslist.store.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import erad.tinyapps.productslist.store.data.repository.ProductsRepositoryImpl
import erad.tinyapps.productslist.store.domain.repository.ProductsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductsRepository(impl: ProductsRepositoryImpl): ProductsRepository
}