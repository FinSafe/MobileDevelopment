package com.example.myapplication.ui.customview

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.example.myapplication.R

class CustomEditText (context: Context, attrs: AttributeSet) : AppCompatEditText(context, attrs){
    init {
        when(id){
            R.id.login_emails -> {
                addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    }

                    override fun afterTextChanged(p0: Editable?) {
                        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
                            val ErrorMessage = context.getString(R.string.error_email)
                            this@CustomEditText.error = ErrorMessage
                        }
                    }
                })
            }

            R.id.login_password -> {
                addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    }

                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                        if (this@CustomEditText.text?.trim().toString().length < 8) {
                            val errorMessage = context.getString(R.string.error_password)
                            this@CustomEditText.error = errorMessage
                        }
                    }

                    override fun afterTextChanged(p0: Editable?) {
                        if (this@CustomEditText.text?.trim().toString().length < 8) {
                            val errorMessage = context.getString(R.string.error_password)
                            this@CustomEditText.error = errorMessage
                        }
                    }
                })
            }
        }
    }
}