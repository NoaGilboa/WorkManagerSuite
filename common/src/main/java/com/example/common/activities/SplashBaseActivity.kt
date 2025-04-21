package com.example.common.activities

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import com.example.mylibrary.R

abstract class SplashBaseActivity : AppCompatActivity() {

    abstract fun getLogoResId(): Int
    abstract fun getNextActivity(): Class<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logoImage: ImageView = findViewById(R.id.splash_logo)
        logoImage.setImageResource(getLogoResId())

        animateLogo(logoImage)
    }

    private fun animateLogo(view: View) {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        view.scaleX = 0f
        view.scaleY = 0f
        view.alpha = 0f

        view.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(2500)
                .setInterpolator(LinearOutSlowInInterpolator())
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator) {
                        view.visibility = View.VISIBLE
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        startActivity(Intent(this@SplashBaseActivity, getNextActivity()))
                        finish()                    }

                    override fun onAnimationCancel(animation: Animator) {}
                    override fun onAnimationRepeat(animation: Animator) {}
                })
    }
}