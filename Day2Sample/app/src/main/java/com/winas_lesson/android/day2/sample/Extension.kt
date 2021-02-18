package com.winas_lesson.android.day2.sample

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.MarginLayoutParamsCompat

val Int.dp: Int
    get() {
        val d = App.context.resources.displayMetrics.density
        return (this.toFloat() / d + 0.5).toInt()
    }

val Int.pixel: Int
    get() {
        val d = App.context.resources.displayMetrics.density
        return (this.toFloat() * d + 0.5).toInt()
    }

val Double.dp: Int
    get() {
        val d = App.context.resources.displayMetrics.density
        return (this.toFloat() / d + 0.5).toInt()
    }

val Double.pixel: Int
    get() {
        val d = App.context.resources.displayMetrics.density
        return (this.toFloat() * d + 0.5).toInt()
    }

val Float.dp: Int
    get() {
        val d = App.context.resources.displayMetrics.density
        return (this / d + 0.5).toInt()
    }

val Float.pixel: Int
    get() {
        val d = App.context.resources.displayMetrics.density
        return (this * d + 0.5).toInt()
    }

var View.layoutWidth: Int
    get() {
        val params = this.layoutParams
        return params.width
    }
    set(value) {
        var params = this.layoutParams
        params.width = value
        this.layoutParams = params
    }

var View.layoutHeight: Int
    get() {
        val params = this.layoutParams
        return params.height
    }
    set(value) {
        var params = this.layoutParams
        params.height = value
        this.layoutParams = params
    }
var View.layoutGravity: Int?
    get() {
        (layoutParams as? FrameLayout.LayoutParams)?.let { params ->
            return params.gravity
        }
        return null
    }
    set(value) {
        (layoutParams as? FrameLayout.LayoutParams)?.let { params ->
            if (value != null) {
                params.gravity = value
                layoutParams = params
            }
        }
    }

var View.marginTop: Int?
    get() {
        (layoutParams as? ViewGroup.MarginLayoutParams)?.let { params ->
            return params.topMargin
        }
        return null
    }
    set(value) {
        (layoutParams as? ViewGroup.MarginLayoutParams)?.let { params ->
            params.topMargin = value ?: 0
            layoutParams = params
        }
    }

var View.marginBottom: Int?
    get() {
        (layoutParams as? ViewGroup.MarginLayoutParams)?.let { params ->
            return params.bottomMargin
        }
        return null
    }
    set(value) {
        (layoutParams as? ViewGroup.MarginLayoutParams)?.let { params ->
            params.bottomMargin = value ?: 0
            layoutParams = params
        }
    }

var View.marginStart: Int?
    get() {
        (layoutParams as? ViewGroup.MarginLayoutParams)?.let { params ->
            return MarginLayoutParamsCompat.getMarginStart(params)
        }
        return null
    }
    set(value) {
        (layoutParams as? ViewGroup.MarginLayoutParams)?.let { params ->
            MarginLayoutParamsCompat.setMarginStart(params, value ?: 0)
            layoutParams = params
        }
    }

var View.marginEnd: Int?
    get() {
        (layoutParams as? ViewGroup.MarginLayoutParams)?.let { params ->
            return MarginLayoutParamsCompat.getMarginEnd(params)
        }
        return null
    }
    set(value) {
        (layoutParams as? ViewGroup.MarginLayoutParams)?.let { params ->
            MarginLayoutParamsCompat.setMarginEnd(params, value ?: 0)
            layoutParams = params
        }
    }
