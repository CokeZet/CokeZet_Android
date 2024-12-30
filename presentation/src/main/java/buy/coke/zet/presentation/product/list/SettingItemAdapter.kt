package buy.coke.zet.presentation.product.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import buy.coke.zet.presentation.databinding.SettingCardLayoutBinding

class SettingItemAdapter(private val itemList: List<String>): RecyclerView.Adapter<SettingItemAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SettingCardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    inner class ViewHolder(val binding: SettingCardLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String) {
            binding.name = name
        }
    }
}