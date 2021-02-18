package com.winas_lesson.android.day2.sample

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.Transformation
import android.widget.Button
import android.widget.ImageView
import androidx.viewbinding.ViewBinding
import com.winas_lesson.android.day2.sample.databinding.ActivityMainBinding
import timber.log.Timber
import kotlin.properties.Delegates

class MainActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}