package br.com.dan.businesscardapp.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.dan.businesscardapp.data.Businesscard
import br.com.dan.businesscardapp.databinding.ItemBusinessCardBinding

class BusinesscardAdapter : ListAdapter<Businesscard, BusinesscardAdapter.ViewHolder>(DiffCallback()) {

    var listnerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Businesscard) {
            binding.tvName.text = item.name
            binding.tvEmail.text = item.emailAdress
            binding.tvEnterprise.text = item.enterprise
            binding.tvPhoneNumber.text = item.phone
            binding.cdView.setCardBackgroundColor(Color.parseColor("#" + java.lang.Integer.toHexString(item.backgroundColor.toInt())))
            binding.cdView.setOnClickListener{
                listnerShare(it)
            }
        }
    }
}

class DiffCallback: DiffUtil.ItemCallback<Businesscard>(){

    override fun areItemsTheSame(oldItem: Businesscard, newItem: Businesscard): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Businesscard, newItem: Businesscard): Boolean {
        return oldItem.id == newItem.id
    }

}