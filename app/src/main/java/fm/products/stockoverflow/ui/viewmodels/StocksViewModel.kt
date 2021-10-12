package fm.products.stockoverflow.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fm.products.stockoverflow.database.enteties.Stock
import fm.products.stockoverflow.repository.ServerApiRepository
import fm.products.stockoverflow.repository.StocksRepository
import fm.products.stockoverflow.utils.toStock
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StocksViewModel(
    private val serverApiRepository: ServerApiRepository,
    private val stocksRepository: StocksRepository
) : ViewModel() {

    private val _stocks = MutableLiveData<List<Stock>>()
    val stocks: LiveData<List<Stock>>
        get() = _stocks

    private val _showLoadProgress = MutableLiveData<Boolean>()
    val showLoadProgress: LiveData<Boolean>
        get() = _showLoadProgress

    private val _showStockDialog = MutableLiveData<Stock>()
    val showStockDialog: LiveData<Stock>
        get() = _showStockDialog

    fun loadStocks() {
        _showLoadProgress.value = true
        viewModelScope.launch(Dispatchers.IO) {
            val stocksFromNetwork = serverApiRepository.loadStocks()
            if (stocksFromNetwork == null) {
                val stocksFromDatabase = stocksRepository.loadStocks()
                displayStocks(stocksFromDatabase)
            } else {
                stocksFromNetwork.map { it.toStock() }.let {
                    stocksRepository.upsertAllStocks(it)
                    displayStocks(it)
                }

            }
        }
    }

    private fun displayStocks(stocks: List<Stock>) = viewModelScope.launch(Dispatchers.Main){
        _stocks.value = stocks
        _showLoadProgress.value = false
    }

    fun onStockClick(stock: Stock){
        _showStockDialog.value = stock
    }

}