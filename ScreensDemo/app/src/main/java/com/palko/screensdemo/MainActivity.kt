package com.palko.screensdemo

import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.hardware.display.DisplayManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        supportActionBar?.hide()
        actionBar?.hide()

        val displayManager = getSystemService(Context.DISPLAY_SERVICE) as DisplayManager
        val displays = displayManager.displays

        Log.i("MAIN ACTIVITY", "Number of displays is "+displays.size)



        if (displays.size > 1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                // Activity options are used to select the display screen.
                val options = ActivityOptions.makeBasic()
                // Select the display screen that you want to show the second activity
                options.launchDisplayId = displays[1].displayId
                // To display on the second screen that your intent must be set flag to make
                // single task (combine FLAG_ACTIVITY_CLEAR_TOP and FLAG_ACTIVITY_NEW_TASK)
                // or you also set it in the manifest (see more at the manifest file)
                startActivity(
                    Intent(this@MainActivity, SecondActivity::class.java),
                    options.toBundle()
                )
                Log.i("MAIN ACTIVITY", "Multiple displays found.")
            }
        }else {
            Log.i("MAIN ACTIVITY", "Device does not have multiple displays.")
        }

    }
}
