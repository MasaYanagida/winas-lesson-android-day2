package com.winas_lesson.android.day2.homework

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.viewbinding.ViewBinding
import com.winas_lesson.android.day2.homework.databinding.ActivityMainBinding
import com.winas_lesson.android.day2.homework.AbstractActivity
import com.winas_lesson.android.day2.homework.ViewBindable
import com.winas_lesson.android.day2.homework.showToast

class MainActivity : AbstractActivity(), ViewBindable {
    override lateinit var binding: ViewBinding
    private val frameLayoutButton: Button?
        get() = (binding as? ActivityMainBinding)?.frameLayoutButton
    private val linearLayoutButton: Button?
        get() = (binding as? ActivityMainBinding)?.linearLayoutButton
    private val relativeLayoutButton: Button?
        get() = (binding as? ActivityMainBinding)?.relativeLayoutButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        frameLayoutButton?.setOnClickListener {
            val intent = Intent(applicationContext, FrameLayoutActivity::class.java)
            startActivity(intent)
        }
        linearLayoutButton?.setOnClickListener {
            val intent = Intent(applicationContext, LinearLayoutActivity::class.java)
            startActivity(intent)
        }
        relativeLayoutButton?.setOnClickListener {
            val intent = Intent(applicationContext, RelativeLayoutActivity::class.java)
            startActivity(intent)
        }
    }
}
