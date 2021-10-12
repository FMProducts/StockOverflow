package fm.products.stockoverflow.database.enteties

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stocks")
data class Stock(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "type")
    var type: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "acronym")
    var acronym: String?,
    @ColumnInfo(name = "mic")
    var mic: String?,
    @ColumnInfo(name = "operating_mic")
    val operatingMic: String?,
    @ColumnInfo(name = "participant_id")
    val participantId: String?,
    @ColumnInfo(name = "url")
    val url: String
)