package com.adhanjas.animations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adhanjas.animations.databinding.ActivitySubmissionBinding

class SubmissionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubmissionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySubmissionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.submit.setOnClickListener {
            ConfirmationDialogFragment().show(supportFragmentManager,"ConfirmationDialogFragment")
        }
    }
}