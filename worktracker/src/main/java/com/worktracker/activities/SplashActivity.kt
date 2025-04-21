package com.worktracker.activities

import android.os.Bundle
import com.example.common.activities.SplashBaseActivity
import com.example.workmanagersuite.R

class SplashActivity : SplashBaseActivity() {
    override fun getLogoResId(): Int = R.drawable.ic_worker_logo
    override fun getNextActivity(): Class<*> = MainActivity::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}