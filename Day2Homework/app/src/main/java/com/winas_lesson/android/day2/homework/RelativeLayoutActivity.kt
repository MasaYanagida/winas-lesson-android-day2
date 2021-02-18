package com.winas_lesson.android.day2.homework

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.Transformation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.viewbinding.ViewBinding
import com.winas_lesson.android.day2.homework.databinding.RelativeLayoutActivityBinding

class RelativeLayoutActivity: AbstractActivity(), ViewBindable {
    override lateinit var binding: ViewBinding
    private var isExpand: Boolean = false
    private val nameView: TextView?
        get() = (binding as? RelativeLayoutActivityBinding)?.nameView
    private val addressView: TextView?
        get() = (binding as? RelativeLayoutActivityBinding)?.addressView
    private val introductionView: TextView?
        get() = (binding as? RelativeLayoutActivityBinding)?.introductionView
    private val favoriteButton: Button?
        get() = (binding as? RelativeLayoutActivityBinding)?.favoriteButton
    private val imageView: ImageView?
        get() = (binding as? RelativeLayoutActivityBinding)?.imageView
    private val toggleButton: Button?
        get() = (binding as? RelativeLayoutActivityBinding)?.toggleButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RelativeLayoutActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val content = Content.create()
        nameView?.text = content.name
        addressView?.text = content.address
        introductionView?.text = content.description
        favoriteButton?.visibility = if (content.showFavoriteButton) View.VISIBLE else View.GONE
        favoriteButton?.setOnClickListener {
            showToast("お気に入りに登録しました")
        }
        toggleButton?.setOnClickListener {
            toggle()
        }
    }
    private fun toggle() {
        val heightStart = if (!isExpand) 200.pixel else 300.pixel
        val heightEnd = if (!isExpand) 300.pixel else 200.pixel
        val marginStart = if (!isExpand) 0.pixel else 20.pixel
        val marginEnd = if (!isExpand) 20.pixel else 0.pixel
        val animation = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
                this@RelativeLayoutActivity.imageView?.layoutHeight =
                    heightStart - (interpolatedTime.toDouble() * (heightStart - heightEnd).toDouble()).toInt()
                this@RelativeLayoutActivity.imageView?.marginStart =
                    marginStart - (interpolatedTime.toDouble() * (marginStart - marginEnd).toDouble()).toInt()
                this@RelativeLayoutActivity.imageView?.marginEnd =
                    marginStart - (interpolatedTime.toDouble() * (marginStart - marginEnd).toDouble()).toInt()
            }
        }
        animation.interpolator = LinearInterpolator()
        animation.duration = 240L
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(p0: Animation?) {
                isExpand = !isExpand
            }
            override fun onAnimationStart(p0: Animation?) {}
            override fun onAnimationRepeat(p0: Animation?) {}
        })
        imageView?.startAnimation(animation)
    }
}
