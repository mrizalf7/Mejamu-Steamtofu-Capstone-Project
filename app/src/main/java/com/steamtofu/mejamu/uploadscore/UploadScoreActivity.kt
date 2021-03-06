package com.steamtofu.mejamu.uploadscore

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.steamtofu.mejamu.R
import com.steamtofu.mejamu.databinding.ActivityUploadScoreBinding

class UploadScoreActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUploadScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChooseFile.setOnClickListener(this)
        binding.btnUpload.setOnClickListener(this)

        supportActionBar?.title="Upload Score"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // using uri path to do something here
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        binding.tvFilePath.text = uri?.path
        Log.d("uri", "onContentTake: ${uri?.path}")
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_choose_file -> {
                getContent.launch("*/*")
            }
            R.id.btn_upload -> {
                Log.d("UPLOAD FILE", "onClick: UPLOADING FILE...")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}