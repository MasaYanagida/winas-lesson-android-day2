package com.winas_lesson.android.day2.homework

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.winas_lesson.android.day2.homework.databinding.LinearLayoutActivityBinding
import com.winas_lesson.android.day2.sample.AbstractActivity
import com.winas_lesson.android.day2.sample.ViewBindable

class LinearLayoutActivity: AbstractActivity(), ViewBindable {
    override lateinit var binding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LinearLayoutActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}
