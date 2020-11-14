package com.palko.demoscreens

import android.app.Presentation
import android.content.Context
import android.os.Bundle
import android.view.Display

class SecondActivity(outerContext: Context?, display: Display?) :
    Presentation(outerContext, display) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_second)
    }
}