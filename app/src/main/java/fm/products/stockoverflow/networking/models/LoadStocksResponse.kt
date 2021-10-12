package fm.products.stockoverflow.networking.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoadStocksResponse(
    @Expose
    @SerializedName("results")
    val results: List<PolygonStock>,
    @Expose
    @SerializedName("status")
    val status: String
)