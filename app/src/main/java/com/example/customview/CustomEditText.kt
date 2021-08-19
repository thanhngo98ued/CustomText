package com.example.customview

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.item_edit_text.view.*

class CustomEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {


    init {
        init(attrs)
    }

    @SuppressLint("Recycle")
    private fun init(attrs: AttributeSet?) {
        LayoutInflater.from(context).inflate(R.layout.item_edit_text, this, true)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomEditText)
        try {
            canEditText = typedArray.getBoolean(R.styleable.CustomEditText_can_edit, true)
            val data = typedArray.getString(R.styleable.CustomEditText_android_text)
            setText(data)
        } finally {
            typedArray.recycle()
        }

    }

    var canEditText: Boolean = true
        set(value) {
            if (field == value) return
            editText.apply {
                if (value) {
                    isFocusable = true
                    isFocusableInTouchMode = true
                    isEnabled = true
                } else {
                    isFocusable = false
                    isFocusableInTouchMode = false
                    isEnabled = false
                    keyListener = null
                }
            }
            field = value
        }

    fun setText(data: String?) {
        textViewTitle.text = data
    }
}
