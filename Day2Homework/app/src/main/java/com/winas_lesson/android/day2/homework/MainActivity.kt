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
import com.winas_lesson.android.day2.homework.databinding.ActivityMainBinding
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import timber.log.Timber
import kotlin.properties.Delegates

class MainActivity : AbstractActivity(), ViewBindable {
    override lateinit var binding: ViewBinding
    // readonly property
    private val toggleButton: Button?
        get() = (binding as? ActivityMainBinding)?.toggleButton
    private val favoriteButton: Button?
        get() = (binding as? ActivityMainBinding)?.buttonFavorite
    private val imageView: ImageView?
        get() = (binding as? ActivityMainBinding)?.imageView
    private val textName: TextView?
        get() = (binding as? ActivityMainBinding)?.textName
    private val textAddress : TextView?
        get() = (binding as? ActivityMainBinding)?.textAddress
    private val textDescription : TextView?
        get() = (binding as? ActivityMainBinding)?.textDescription

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //setContentView(R.layout.activity_main)
        val content = Content.create()
        textName?.text = content.name
        textAddress?.text = content.address
        textDescription?.text = content.description
        this.favoriteButton!!.visibility = if (content.showFavoriteButton) View.VISIBLE else View.GONE



        toggleButton?.setOnClickListener {
            toggle()
        }

        favoriteButton?.setOnClickListener(){
            Toast.makeText(applicationContext,"お気に入りに登録しました",Toast.LENGTH_LONG).show()
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