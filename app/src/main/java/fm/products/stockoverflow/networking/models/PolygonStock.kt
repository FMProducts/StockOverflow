package fm.products.stockoverflow.networking.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PolygonStock(
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("type")
    val type: String,
    @Expose
    @SerializedName("asset_class")
    val assetsClass: String,
    @Expose
    @SerializedName("locale")
    val locale: String,
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("acronym")
    val acronym: String?,
    @Expose
    @SerializedName("mic")
    val mic: String?,
    @Expose
    @SerializedName("operating_mic")
    val operatingMic: String?,
    @Expose
    @SerializedName("participant_id")
    val participantId: String?,
    @Expose
    @SerializedName("url")
    val url: String
)