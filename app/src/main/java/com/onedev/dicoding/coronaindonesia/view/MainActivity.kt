package com.onedev.dicoding.coronaindonesia.view

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.onedev.dicoding.coronaindonesia.R
import com.onedev.dicoding.coronaindonesia.adapter.ProvinceAdapter
import com.onedev.dicoding.coronaindonesia.databinding.ActivityMainBinding
import com.onedev.dicoding.coronaindonesia.model.Attributes
import com.onedev.dicoding.coronaindonesia.model.ProvinceItem
import com.onedev.dicoding.coronaindonesia.utils.Constant
import com.onedev.dicoding.coronaindonesia.utils.PreferenceManager
import com.onedev.dicoding.coronaindonesia.utils.Support
import com.onedev.dicoding.coronaindonesia.viewmodel.MainViewModel
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: ProvinceAdapter
    private lateinit var mProvinceItem: ArrayList<ProvinceItem>
    private lateinit var viewModel: MainViewModel
    private lateinit var preferenceManager: PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgClear.setOnClickListener(this)
        preferenceManager = PreferenceManager(this@MainActivity)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        bindingUI()
        loadProvince()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.menuSearch).actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search_province)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filter(newText)
                return true
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuAbout -> {
                startActivity(Intent(this@MainActivity, AboutActivity::class.java))
                true
            }
            else -> true
        }
    }

    private fun filter(text: String) {
        val filteredList: ArrayList<ProvinceItem> = ArrayList()
        for (i in mProvinceItem) {
            if (i.attributes.Provinsi.lowercase(Locale.getDefault()).contains(text.lowercase(Locale.getDefault()))) {
                filteredList.add(i)
            }
        }
        adapter.filterList(filteredList)
    }

    private fun loadProvince() {
        viewModel.getProvince()

        viewModel.showProgress.observe(this@MainActivity, {
            if (it) {
                binding.progressCircular.visibility = View.VISIBLE
            } else {
                binding.progressCircular.visibility = View.GONE
            }
        })

        viewModel.province.observe(this@MainActivity, {
            if (it.isNotEmpty()) {
                mProvinceItem = ArrayList()
                mProvinceItem.addAll(it)
                adapter = ProvinceAdapter(it)
                binding.rvProvinceWithPositiveCase.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rvProvinceWithPositiveCase.adapter = adapter

                adapter.setOnItemClickCallback(object : ProvinceAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: Attributes) {
                        preferenceManager.putString(Constant.PROVINCE, data.Provinsi)
                        preferenceManager.putString(Constant.CASE_POSITIVE, data.Kasus_Posi.toString())
                        preferenceManager.putString(Constant.CASE_NEGATIVE, data.Kasus_Meni.toString())
                        preferenceManager.putString(Constant.CASE_HEALED, data.Kasus_Semb.toString())
                        bindingUI()
                    }
                })
            }
        })

        binding.rvProvinceWithPositiveCase.setHasFixedSize(true)
    }

    private fun bindingUI() {
        val province = preferenceManager.getString(Constant.PROVINCE)
        if (province == "")
            binding.llInfoPin.visibility = View.GONE
        else {
            binding.llInfoPin.visibility = View.VISIBLE
            binding.tvProvinceName.text = preferenceManager.getString(Constant.PROVINCE)
            binding.tvProvinceCasePositive.text = Support.convertToDec(preferenceManager.getString(Constant.CASE_POSITIVE)!!.toDouble())
            binding.tvProvinceCaseHealed.text = Support.convertToDec(preferenceManager.getString(Constant.CASE_HEALED)!!.toDouble())
            binding.tvProvinceCaseNegative.text = Support.convertToDec(preferenceManager.getString(Constant.CASE_NEGATIVE)!!.toDouble())

            Glide.with(this)
                .load(Support.getImgUrlByProvinceName(preferenceManager.getString(Constant.PROVINCE)!!))
                .into(binding.imgProvince)
        }
    }

    override fun onClick(v: View?) {
        when (v!!) {
            binding.imgClear -> {
                preferenceManager.clearPreferences()
                bindingUI()
            }
        }
    }

}