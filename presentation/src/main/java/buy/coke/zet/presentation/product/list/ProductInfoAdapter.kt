package buy.coke.zet.presentation.product.list

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import buy.coke.zet.presentation.databinding.LayoutIntroduceProductListBinding
import buy.coke.zet.presentation.databinding.LayoutMoreButtonBinding
import buy.coke.zet.presentation.databinding.ProductCardLayoutBinding
import buy.coke.zet.presentation.product.detail.ProductDetailActivity

class ProductInfoAdapter(private val moreButtonClickListener: () -> Unit) : ListAdapter<ProductInfo, RecyclerView.ViewHolder>(diffCallback) {
    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<ProductInfo>() {
            override fun areItemsTheSame(oldItem: ProductInfo, newItem: ProductInfo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ProductInfo, newItem: ProductInfo): Boolean {
                return oldItem.title == newItem.title
            }
        }

        const val INTRODUCE_ITEM_INDEX = -1
        const val MORE_ITEM_INDEX = -2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == INTRODUCE_ITEM_INDEX) {
            val binding = LayoutIntroduceProductListBinding.inflate(layoutInflater, parent, false)
            ProductIntroduceViewHolder(binding)
        } else if (viewType == MORE_ITEM_INDEX) {
            val binding = LayoutMoreButtonBinding.inflate(layoutInflater, parent, false)
            binding.root.setOnClickListener { moreButtonClickListener() }
            MoreButtonViewHolder(binding)
        } else {
            val binding = ProductCardLayoutBinding.inflate(layoutInflater, parent, false)
            ProductInfoViewHolder(binding, parent.context)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) != INTRODUCE_ITEM_INDEX && getItemViewType(position) != MORE_ITEM_INDEX) {
            (holder as ProductInfoViewHolder).bind(getItem(position))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return currentList[position].id
    }

    class ProductInfoViewHolder(private val binding: ProductCardLayoutBinding, private val context: Context): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductInfo) {
            binding.productInfo = item
            binding.root.setOnClickListener { context.startActivity(Intent(context, ProductDetailActivity::class.java)) }
            binding.executePendingBindings()
        }
    }

    class ProductIntroduceViewHolder(binding: LayoutIntroduceProductListBinding): RecyclerView.ViewHolder(binding.root)

    class MoreButtonViewHolder(binding: LayoutMoreButtonBinding): RecyclerView.ViewHolder(binding.root)
}
