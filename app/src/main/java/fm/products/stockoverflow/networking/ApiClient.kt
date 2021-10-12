package fm.products.stockoverflow.networking

import fm.products.stockoverflow.utils.API_BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{

        fun getInstance(): PolygonApi {
            return createPolygonClient()
        }

        private fun createPolygonClient(): PolygonApi{
            return Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PolygonApi::class.java)
        }
    }
}