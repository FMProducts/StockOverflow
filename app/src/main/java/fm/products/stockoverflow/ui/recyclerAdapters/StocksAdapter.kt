package fm.products.stockoverflow.ui.recyclerAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fm.products.stockoverflow.database.enteties.Stock
import fm.products.stockoverflow.databinding.StockRecyclerItemBinding

class StocksAdapter(
    context: Context,
    private var stocks: List<Stock>
) : RecyclerView.Adapter<StocksAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    var onItemSelectListener: ((Stock) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StockRecyclerItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stock = stocks[position]
        holder.binding.stockName.text = stock.name
        holder.binding.stockType.text = stock.type
        holder.binding.stockUrl.text = stock.url
        holder.binding.mainLayout.setOnClickListener { onItemSelectListener?.invoke(stock) }
    }

    fun setStocks(newStocks: List<Stock>){
        stocks = newStocks
        notifyDataSetChanged()
    }

    override fun getItemCount() = stocks.size

    class ViewHolder(val binding: StockRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)
}