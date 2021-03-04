package com.winas_lesson.android.day2.homework

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.winas_lesson.android.day2.homework.databinding.LinearLayoutActivityBinding
import com.winas_lesson.android.day2.homework.AbstractActivity
import com.winas_lesson.android.day2.homework.Content
import com.winas_lesson.android.day2.homework.ViewBindable
import kotlinx.android.synthetic.main.frame_layout_activity.view.*

class LinearLayoutActivity: AbstractActivity(), ViewBindable {
    override lateinit var binding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LinearLayoutActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val content = Content.create()

        view.tvName.text = content.name
        view.tvAddress.text = content.address
        view.tvIntroduction.text = content.description
        if (content.showFavoriteButton) {
            view.btnFavorite.visibility = View.VISIBLE
        } else {
            view.btnFavorite.visibility = View.GONE
        }

        view.btnFavorite.setOnClickListener {
            makeToast("お気に入りに登録しました")
        }
        view.btnImageChangeSize.setOnClickListener {
            if (view.ivFig.layoutHeight == resources.getDimensionPixelSize(R.dimen.normal_height)) {
                view.ivFig.layoutHeight = resources.getDimensionPixelSize(R.dimen.big_height)
            } else {
                view.ivFig.layoutHeight = resources.getDimensionPixelSize(R.dimen.normal_height)
            }
        }
    }

    private fun makeToast(text: String) {
        val toast = Toast.makeText(applicationContext, text, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, -200)
        toast.show()
    }
}
