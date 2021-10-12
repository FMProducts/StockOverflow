package fm.products.stockoverflow.repository.impl

import fm.products.stockoverflow.database.AppDatabase
import fm.products.stockoverflow.database.enteties.Stock
import fm.products.stockoverflow.repository.StocksRepository

class StocksRepositoryImpl(
    private val database: AppDatabase
): StocksRepository {
    override fun upsertAllStocks(stocks: List<Stock>) {
        database.stocksDao().insert(stocks)
    }

    override fun loadStocks() =  database.stocksDao().getStocks()
}