package com.sawapps.space.customViews

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import com.sawapps.space.R
import kotlinx.android.synthetic.main.view_empty.view.*

/**
 * Created by Mateusz Sawa on 15/11/2020.
 */
class EmptyPageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    init {
        inflate(context, R.layout.view_empty, this)
        context.withStyledAttributes(attrs, R.styleable.EmptyPageView, defStyle, 0) {
            imageView.setImageDrawable(getDrawable(R.styleable.EmptyPageView_src))
            textView.text = getString(R.styleable.EmptyPageView_text)
        }
    }
}