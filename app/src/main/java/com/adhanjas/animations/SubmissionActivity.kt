package com.adhanjas.animations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.adhanjas.animations.databinding.ActivitySubmissionBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmissionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubmissionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySubmissionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.submit.setOnClickListener {
            showConfirmationDialog()
        }
    }
    private fun showConfirmationDialog(){
        val viewGroup=findViewById<ViewGroup>(android.R.id.content)
        val dialogView: View = LayoutInflater.from(this).inflate(R.layout.fragment_confirmation_dialog,viewGroup,false)

        val agree:Button=dialogView.findViewById(R.id.agree)
        val close:ImageView=dialogView.findViewById(R.id.cancel)

        val builder=AlertDialog.Builder(this)
        builder.setView(dialogView)
        val alertDialog=builder.create()
        alertDialog.show()

        close.setOnClickListener {
            alertDialog.dismiss()
        }

        agree.setOnClickListener {
            sendData(binding.firstName.text.toString(),
                binding.lastName.text.toString(),
                binding.email.text.toString(),
                binding.gitlink.text.toString())

            alertDialog.dismiss()
        }


    }
    private fun sendData(firstName:String,lastName:String,email:String,link:String){
        AnimationsApi.apiService3.submitProject(firstName,lastName,email,link).enqueue(object :Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                SuccessFragment().show(supportFragmentManager,"Success")
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                FaliureFragment().show(supportFragmentManager,"failed")
            }

        })
    }
}