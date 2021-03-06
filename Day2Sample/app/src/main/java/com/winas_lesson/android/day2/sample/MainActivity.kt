package com.winas_lesson.android.day2.sample

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.Transformation
import android.widget.Button
import android.widget.ImageView
import androidx.viewbinding.ViewBinding
import com.winas_lesson.android.day2.sample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import kotlin.properties.Delegates

class MainActivity : AbstractActivity(), ViewBindable {
    override lateinit var binding: ViewBinding
    // readonly property
    private val toggleButton: Button?
        get() = (binding as? ActivityMainBinding)?.button
    private val imageView: ImageView?
        get() = (binding as? ActivityMainBinding)?.imageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)

        button?.setOnClickListener {
            toggle()
        }
    }

    private var isExpand: Boolean = false
    private fun toggle() {
        val heightStart = if (!isExpand) 200.pixel else 300.pixel
        val heightEnd = if (!isExpand) 300.pixel else 200.pixel
        val marginStart = if (!isExpand) 0.pixel else 20.pixel
        val marginEnd = if (!isExpand) 20.pixel else 0.pixel

        val animation = object : Animation() {
            override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
                this@MainActivity.imageView?.layoutHeight =
                    heightStart - (interpolatedTime.toDouble() * (heightStart - heightEnd).toDouble()).toInt()
                this@MainActivity.imageView?.marginStart =
                    marginStart - (interpolatedTime.toDouble() * (marginStart - marginEnd).toDouble()).toInt()
                this@MainActivity.imageView?.marginEnd =
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