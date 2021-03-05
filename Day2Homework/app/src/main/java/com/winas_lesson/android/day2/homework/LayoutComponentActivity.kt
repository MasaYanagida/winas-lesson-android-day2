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
import com.winas_lesson.android.day2.homework.databinding.FrameLayoutActivityBinding
import com.winas_lesson.android.day2.homework.databinding.LinearLayoutActivityBinding
import com.winas_lesson.android.day2.homework.databinding.RelativeLayoutActivityBinding
import timber.log.Timber

enum class LayoutComponentType(val key: Int) {
    FRAME(1), LINEAR(2), RELATIVE(3);
}

class LayoutComponentActivity : AbstractActivity(), ViewBindable {
    override lateinit var binding: ViewBinding
    private var isExpand: Boolean = false
    private val nameView: TextView?
        get() = (binding as? RelativeLayoutActivityBinding)?.nameView
            ?: (binding as? LinearLayoutActivityBinding)?.nameView
            ?: (binding as? FrameLayoutActivityBinding)?.nameView
    private val addressView: TextView?
        get() = (binding as? RelativeLayoutActivityBinding)?.addressView
            ?: (binding as? LinearLayoutActivityBinding)?.addressView
            ?: (binding as? FrameLayoutActivityBinding)?.addressView
    private val introductionView: TextView?
        get() = (binding as? RelativeLayoutActivityBinding)?.introductionView
            ?: (binding as? LinearLayoutActivityBinding)?.introductionView
            ?: (binding as? FrameLayoutActivityBinding)?.introductionView
    private val favoriteButton: Button?
        get() = (binding as? RelativeLayoutActivityBinding)?.favoriteButton
            ?: (binding as? LinearLayoutActivityBinding)?.favoriteButton
            ?: (binding as? FrameLayoutActivityBinding)?.favoriteButton
    private val imageView: ImageView?
        get() = (binding as? RelativeLayoutActivityBinding)?.imageView
            ?: (binding as? LinearLayoutActivityBinding)?.imageView
            ?: (binding as? FrameLayoutActivityBinding)?.imageView
    private val toggleButton: Button?
        get() = (binding as? RelativeLayoutActivityBinding)?.toggleButton
            ?: (binding as? LinearLayoutActivityBinding)?.toggleButton
            ?: (binding as? FrameLayoutActivityBinding)?.toggleButton

    companion object {
        const val EXTRA_COMPONENT_TYPE = "EXTRA_COMPONENT_TYPE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val typeId = intent.getIntExtra(EXTRA_COMPONENT_TYPE, LayoutComponentType.FRAME.key)
        Timber.d("#issue typeId= $typeId!!")
        binding = when (typeId) {
            LayoutComponentType.FRAME.key -> FrameLayoutActivityBinding.inflate(layoutInflater)
            LayoutComponentType.LINEAR.key -> LinearLayoutActivityBinding.inflate(layoutInflater)
            LayoutComponentType.RELATIVE.key -> RelativeLayoutActivityBinding.inflate(layoutInflater)
            else -> FrameLayoutActivityBinding.inflate(layoutInflater)
        }
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
                this@LayoutComponentActivity.imageView?.layoutHeight =
                    heightStart - (interpolatedTime.toDouble() * (heightStart - heightEnd).toDouble()).toInt()
                this@LayoutComponentActivity.imageView?.marginStart =
                    marginStart - (interpolatedTime.toDouble() * (marginStart - marginEnd).toDouble()).toInt()
                this@LayoutComponentActivity.imageView?.marginEnd =
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
