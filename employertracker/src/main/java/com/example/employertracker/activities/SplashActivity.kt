package com.example.employertracker.activities

import android.os.Bundle
import com.example.common.activities.SplashBaseActivity
import com.example.employertracker.R

class SplashActivity : SplashBaseActivity() {
    override fun getLogoResId(): Int = R.drawable.ic_employer_logo
    override fun getNextActivity(): Class<*> = MainActivity::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}