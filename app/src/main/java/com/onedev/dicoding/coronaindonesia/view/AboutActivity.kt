package com.onedev.dicoding.coronaindonesia.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.onedev.dicoding.coronaindonesia.R
import com.onedev.dicoding.coronaindonesia.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.about_me)

        Glide.with(this)
            .load(R.drawable.profile)
            .circleCrop()
            .into(binding.imgProfile)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}