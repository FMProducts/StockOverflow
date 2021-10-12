package fm.products.stockoverflow.database

import androidx.room.*
import fm.products.stockoverflow.database.enteties.Stock

@Dao
interface StocksDAO {
    @Query("SELECT * FROM `stocks` WHERE id = :id")
    fun getStock(id: Int): Stock

    @Query("SELECT * FROM `stocks` ORDER BY `id` ASC")
    fun getStocks(): List<Stock>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg settings: Stock)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(settings: List<Stock>)

    @Query("DELETE FROM `stocks`")
    fun deleteAll()

    @Delete
    fun delete(vararg stocks: Stock)
}