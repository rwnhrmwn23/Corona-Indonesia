package com.onedev.dicoding.coronaindonesia.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.onedev.dicoding.coronaindonesia.databinding.ActivityDetailBinding
import com.onedev.dicoding.coronaindonesia.model.Attributes
import com.onedev.dicoding.coronaindonesia.utils.Support

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnShareInfo.setOnClickListener {
            val textToShare = "Update Info Covid Provinsi ${supportActionBar?.title}" +
                    "\nPositive : ${binding.tvProvinceCasePositive.text}" +
                    "\nSembuh : ${binding.tvProvinceCaseHealed.text}" +
                    "\nMeninggal : ${binding.tvProvinceCaseNegative.text}" +
                    "\n\nSumber Data : kawalcorona.com"
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, textToShare)
            startActivity(Intent.createChooser(intent, "Share"))
        }

        bindingUI()
    }

    private fun bindingUI() {
        val data = intent.getParcelableExtra<Attributes>(EXTRA_DATA)
        Glide.with(this)
            .load(Support.getImgUrlByProvinceName(data!!.Provinsi))
            .into(binding.imgProvince)
        binding.tvProvinceCasePositive.text = Support.convertToDec(data.Kasus_Posi.toDouble())
        binding.tvProvinceCaseHealed.text = Support.convertToDec(data.Kasus_Semb.toDouble())
        binding.tvProvinceCaseNegative.text = Support.convertToDec(data.Kasus_Meni.toDouble())
        supportActionBar?.title = data.Provinsi
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}