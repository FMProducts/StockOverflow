package fm.products.stockoverflow.networking

import fm.products.stockoverflow.networking.models.LoadStocksResponse
import fm.products.stockoverflow.utils.API_AUTH_TOKEN
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * https://polygon.io/docs/
 */

interface PolygonApi {
    @GET("exchanges")
    suspend fun loadStocks(
        @Query("locale") locale: String,
        @Query("apiKey") apiKey: String,
        @Query("assets_class") assetClass: String = "stocks", // stocks by default
        @Header("Authorization") bearerToken: String = API_AUTH_TOKEN,
    ): LoadStocksResponse?
}