package com.hana897trx.bloodtec.ui.home.customViews

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.hana897trx.bloodtec.R
import com.hana897trx.bloodtec.databinding.ButtonComponentBinding

typealias ButtonClick = () -> Unit

class ButtonComponent @JvmOverloads constructor (
    ctx: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout (
    ctx,
    attrs,
    defStyleAttr
) {
    private var _binding : ButtonComponentBinding =
        ButtonComponentBinding.inflate(LayoutInflater.from(context), this, true)

    fun onClick(click: ButtonClick) = with(_binding.buttonComponent) {
        setOnClickListener { click() }
    }

    fun buttonType(buttonType: ButtonType = ButtonType.Positive) = with(_binding.buttonComponent) {
        backgroundTintList = when(buttonType) {
            ButtonType.Positive -> {
                ColorStateList.valueOf(context.getColor(R.color.red))
            }
            ButtonType.Negative -> {
                ColorStateList.valueOf(context.getColor(R.color.white))
            }
        }
    }

    fun text(buttonText: String) {
        _binding.buttonComponent.text = buttonText
    }

    enum class ButtonType {
        Positive,
        Negative
    }

}