package fm.products.stockoverflow.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import fm.products.stockoverflow.databinding.StocksFragmentBinding
import fm.products.stockoverflow.ui.recyclerAdapters.StocksAdapter
import fm.products.stockoverflow.ui.viewmodels.StocksViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class StocksFragment : Fragment() {

    private lateinit var binding: StocksFragmentBinding
    private val viewModel: StocksViewModel by sharedViewModel()
    private lateinit var adapter: StocksAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = StocksFragmentBinding.inflate(inflater, container, false)
        adapter = StocksAdapter(requireContext(), listOf())
        binding.recycler.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.stocks.observe(viewLifecycleOwner) {
            adapter.setStocks(it)
        }
        viewModel.showLoadProgress.observe(viewLifecycleOwner) {
            binding.swipeRefreshLayout.isRefreshing = it
        }
        viewModel.showStockDialog.observe(viewLifecycleOwner) {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Вы действительно хотите перейти на вебсайт?")
                .setPositiveButton("Да") { _, _ ->
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(it.url)
                    startActivity(intent)
                }
                .setNegativeButton("Нет"){ _, _ -> }
                .show()
        }

        binding.swipeRefreshLayout.setOnRefreshListener { viewModel.loadStocks() }
        adapter.onItemSelectListener = viewModel::onStockClick
        viewModel.loadStocks()
    }

}