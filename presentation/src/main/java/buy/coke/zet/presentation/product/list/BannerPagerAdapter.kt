package buy.coke.zet.presentation.product.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import buy.coke.zet.presentation.R
import buy.coke.zet.presentation.databinding.LayoutAdvertiseBannerBinding

class BannerPagerAdapter(
    private val bannerList: List<Int>
): RecyclerView.Adapter<BannerPagerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: LayoutAdvertiseBannerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(resourceId: Int) {
            binding.advertiseItem.setImageResource(resourceId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = LayoutAdvertiseBannerBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = bannerList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(bannerList[position])
    }
}