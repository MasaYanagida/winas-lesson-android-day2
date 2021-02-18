package com.winas_lesson.android.day2.homework

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.winas_lesson.android.day2.homework.databinding.RelativeLayoutActivityBinding
import com.winas_lesson.android.day2.sample.AbstractActivity
import com.winas_lesson.android.day2.sample.Content
import com.winas_lesson.android.day2.sample.ViewBindable

class RelativeLayoutActivity: AbstractActivity(), ViewBindable {
    override lateinit var binding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RelativeLayoutActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val content = Content.create()
        // TODO : contentの内容をviewに反映させて、ボタンタップアクションを設定してください
    }
}
