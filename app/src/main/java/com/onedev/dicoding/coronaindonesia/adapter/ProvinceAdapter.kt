package com.onedev.dicoding.coronaindonesia.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onedev.dicoding.coronaindonesia.R
import com.onedev.dicoding.coronaindonesia.databinding.ListCovidIndonesiaBinding
import com.onedev.dicoding.coronaindonesia.model.Attributes
import com.onedev.dicoding.coronaindonesia.model.ProvinceItem
import com.onedev.dicoding.coronaindonesia.utils.Support
import com.onedev.dicoding.coronaindonesia.view.DetailActivity

class ProvinceAdapter(private var listProvince: ArrayList<ProvinceItem>) :
    RecyclerView.Adapter<ProvinceAdapter.ListViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Attributes)
    }

    inner class ListViewHolder(private val binding: ListCovidIndonesiaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(province: ProvinceItem) {
            with(binding) {
                val attrs = province.attributes
                tvProvinceName.text = attrs.Provinsi
                tvProvinceCasePositive.text = itemView.context.getString(R.string.count_cases_positive, Support.convertToDec(attrs.Kasus_Posi.toDouble()))

                Glide.with(itemView.context)
                    .load(Support.getImgUrlByProvinceName(attrs.Provinsi))
                    .circleCrop()
                    .into(imgProvince)

                imgPin.setOnClickListener {
                    onItemClickCallback?.onItemClicked(attrs)
                }

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, attrs)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ListCovidIndonesiaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listProvince[position])
    }

    override fun getItemCount(): Int = listProvince.size

    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filteredList: ArrayList<ProvinceItem>) {
        listProvince = filteredList
        notifyDataSetChanged()
    }
}