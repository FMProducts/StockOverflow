package fm.products.stockoverflow.repository

import fm.products.stockoverflow.networking.models.PolygonStock


interface ServerApiRepository {
    suspend fun loadStocks(): List<PolygonStock>?

}