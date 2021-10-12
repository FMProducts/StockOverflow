package fm.products.stockoverflow.repository.impl

import fm.products.stockoverflow.networking.PolygonApi
import fm.products.stockoverflow.networking.models.PolygonStock
import fm.products.stockoverflow.repository.ServerApiRepository
import fm.products.stockoverflow.utils.API_LOCALE
import java.lang.Exception

class ServerApiRepositoryImpl(
    private val serverApi: PolygonApi
): ServerApiRepository {
    override suspend fun loadStocks(): List<PolygonStock>? {
        return try {
            val response = serverApi.loadStocks(API_LOCALE, API_LOCALE)
            if (response?.status == "OK") response.results else null
        } catch (e: Exception){
            e.printStackTrace()
            null
        }
    }
}