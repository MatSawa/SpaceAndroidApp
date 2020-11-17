package com.sawapps.space.views.launches

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.sawapps.space.R
import com.sawapps.space.adapters.RecyclerAdapter
import com.sawapps.space.views.BaseFragment
import kotlinx.android.synthetic.main.fragment_launches.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Mateusz Sawa on 13/11/2020.
 */
class LaunchesFragment : BaseFragment<LaunchesViewModel>() {
    override val layout: Int = R.layout.fragment_launches
    override val viewModel: LaunchesViewModel by viewModel()

    //We can use here PagedListAdapter
    private val adapter = RecyclerAdapter(
        this, R.layout.row_launch, RequestRowDiffCallback
    ) {
        viewModel.open(it.launch)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
    }

    override fun bindObservables() {
        super.bindObservables()
        viewModel.launches.observe(viewLifecycleOwner, adapter::submitList)
    }
}

object RequestRowDiffCallback : DiffUtil.ItemCallback<LaunchRowViewModel>() {
    override fun areItemsTheSame(oldItem: LaunchRowViewModel, newItem: LaunchRowViewModel) =
        oldItem.launch.id == newItem.launch.id

    override fun areContentsTheSame(oldItem: LaunchRowViewModel, newItem: LaunchRowViewModel) =
        oldItem.launch == newItem.launch
}