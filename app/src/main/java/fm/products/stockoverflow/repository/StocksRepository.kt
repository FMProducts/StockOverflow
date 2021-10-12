package fm.products.stockoverflow.repository

import fm.products.stockoverflow.database.enteties.Stock

interface StocksRepository {
    fun upsertAllStocks(stocks: List<Stock>)
    fun loadStocks(): List<Stock>

}