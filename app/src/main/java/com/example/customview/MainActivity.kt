package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_edit_text.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       initData()
    }

    private fun initData() {
        val titleA = "Noi o"
        val titleB = "Nam sinh"
        layoutA.apply {
            setText(titleA)
            canEditText = false
        }
        layoutB.setText(titleB)
    }
}
