package fm.products.stockoverflow.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fm.products.stockoverflow.database.enteties.Stock
import fm.products.stockoverflow.utils.DB_NAME
import fm.products.stockoverflow.utils.DB_VERSION

@Database(entities = [Stock::class], version = DB_VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun stocksDao(): StocksDAO

    companion object {

        fun getInstance(context: Context): AppDatabase {
            return buildDatabase(context)
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()
        }
    }
}