package com.sawapps.space.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sawapps.space.BR

/**
 * Created by Mateusz Sawa on 14/11/2020.
 */
open class RecyclerAdapter<T : Any>(
    private val lifecycleOwner: LifecycleOwner,
    private val layoutId: Int,
    diffUtilCallback: DiffUtil.ItemCallback<T>,
    private val onClickListener: ((T) -> Unit)? = null
) : ListAdapter<T, ViewHolder>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context), layoutId, parent, false)
    )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder.binding) {
            val item = getItem(position)
            onClickListener?.let { root.setOnClickListener { it(item) } }

            setVariable(BR.viewModel, item)
            lifecycleOwner = this@RecyclerAdapter.lifecycleOwner
            executePendingBindings()
        }
    }

    override fun onViewRecycled(holder: ViewHolder) {
        holder.binding.root.setOnClickListener(null)
        super.onViewRecycled(holder)
    }
}

class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
