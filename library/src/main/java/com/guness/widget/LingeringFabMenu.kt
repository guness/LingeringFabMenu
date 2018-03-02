package com.guness.widget

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.lingering_fab_menu.view.*
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.math.max

/**
 * Created by guness on 24.01.2018.
 */
class LingeringFabMenu : ConstraintLayout {

    private var mOpen = AtomicBoolean(false)
    private var mHeight = 0

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        inflate(getContext(), R.layout.lingering_fab_menu, this)

        fabView.setOnClickListener {
            if (mOpen.get()) {
                rotateFabBackward()
            } else {
                rotateFabForward()
            }
            toggle()
        }

        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.LingeringFabMenu, 0, 0)

        if (a.hasValue(R.styleable.LingeringFabMenu_menu)) {
            inflateMenu(a.getResourceId(R.styleable.LingeringFabMenu_menu, 0))
        }
        if (a.hasValue(R.styleable.LingeringFabMenu_drawable)) {
            val icon = a.getResourceId(R.styleable.LingeringFabMenu_drawable, R.drawable.lingering_rotating_add)
            fabView.setImageResource(icon)
        }

        a.recycle()
    }

    private fun inflateMenu(resourceId: Int) {
        MenuInflater(context).inflate(resourceId, menuView)
    }

    fun findItem(id: Int): MenuItem? {
        return menuView.findItem(id)
    }

    // https://stackoverflow.com/a/47594719
    private fun toggle() {
        var temp: Boolean
        do {
            temp = mOpen.get()
        } while (!mOpen.compareAndSet(temp, !temp))
    }

    private fun rotateFabForward() {

        val anim = ObjectAnimator.ofInt(fabView.drawable, "level", 0, 5000).setDuration(ANIM_DURATION)
        anim.interpolator = OvershootInterpolator(5f)
        anim.start()

        mHeight = max(mHeight, menuView.height)

        val anim2 = ValueAnimator.ofInt(0, mHeight).setDuration(ANIM_DURATION)
        anim2.addUpdateListener {
            val value = it.animatedValue as Int
            if (value > 0) {
                menuView.visibility = View.VISIBLE
            }
            menuView.layoutParams.height = value
            menuView.requestLayout()
        }
        anim2.start()
    }

    private fun rotateFabBackward() {
        val anim = ObjectAnimator.ofInt(fabView.drawable, "level", fabView.drawable.level, 0).setDuration(ANIM_DURATION)
        anim.interpolator = OvershootInterpolator(5f)
        anim.start()

        mHeight = max(mHeight, menuView.height)

        val anim2 = ValueAnimator.ofInt(mHeight, 0).setDuration(ANIM_DURATION)
        anim2.addUpdateListener {

            val value = it.animatedValue as Int
            if (value == 0) {
                menuView.visibility = View.INVISIBLE
            }
            menuView.layoutParams.height = value
            menuView.requestLayout()
        }

        anim2.start()
    }

    fun setOnMenuItemClickListener(listener: MenuItem.OnMenuItemClickListener?) {
        menuView.setOnMenuItemClickListener(listener)
    }

    companion object {
        private const val ANIM_DURATION = 350L
        const val TAG = "LingeringFabMenu"
    }
}