package com.winas_lesson.android.day2.homework

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.winas_lesson.android.day2.homework.databinding.LinearLayoutActivityBinding
import com.winas_lesson.android.day2.homework.AbstractActivity
import com.winas_lesson.android.day2.homework.Content
import com.winas_lesson.android.day2.homework.ViewBindable

class LinearLayoutActivity: AbstractActivity(), ViewBindable {
    override lateinit var binding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LinearLayoutActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val content = Content.create()
        // TODO : contentの内容をviewに反映させて、ボタンタップアクションを設定してください
    }
}
