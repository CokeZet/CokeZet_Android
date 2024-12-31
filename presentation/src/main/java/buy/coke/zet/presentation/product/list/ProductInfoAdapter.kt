package buy.coke.zet.presentation.product.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import buy.coke.zet.presentation.databinding.ProductCardLayoutBinding

class ProductInfoAdapter : ListAdapter<ProductInfo, ProductInfoAdapter.ProductInfoViewHolder>(diffCallback) {
    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<ProductInfo>() {
            override fun areItemsTheSame(oldItem: ProductInfo, newItem: ProductInfo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ProductInfo, newItem: ProductInfo): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductInfoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ProductCardLayoutBinding.inflate(layoutInflater, parent, false)
        return ProductInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductInfoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductInfoViewHolder(private val binding: ProductCardLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ProductInfo) {
            binding.productInfo = item
            binding.executePendingBindings()
        }
    }
}
