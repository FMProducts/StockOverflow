package fm.products.stockoverflow.di

import fm.products.stockoverflow.database.AppDatabase
import fm.products.stockoverflow.networking.ApiClient
import fm.products.stockoverflow.repository.ServerApiRepository
import fm.products.stockoverflow.repository.StocksRepository
import fm.products.stockoverflow.repository.impl.ServerApiRepositoryImpl
import fm.products.stockoverflow.repository.impl.StocksRepositoryImpl
import fm.products.stockoverflow.ui.viewmodels.StocksViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * Модуль для singleton классов
 */
val singletonsModule = module {
    single { ApiClient.getInstance() }
    single { AppDatabase.getInstance(androidContext()) }
}


/**
 * Модуль для репозиториев
 */
val repositoriesModule = module {
    single<ServerApiRepository> {  ServerApiRepositoryImpl(get()) }
    single<StocksRepository> {  StocksRepositoryImpl(get()) }
}


/**
 * Модуль для viewModels
 */
val viewModelsModule = module {
    viewModel { StocksViewModel(get() , get()) }
}