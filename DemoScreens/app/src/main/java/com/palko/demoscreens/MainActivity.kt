package com.palko.demoscreens

import android.content.Context
import android.hardware.display.DisplayManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Display

class MainActivity : AppCompatActivity() {

    var displayManager : DisplayManager? = null
   // var presentationDisplays = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayManager = getSystemService(Context.DISPLAY_SERVICE) as DisplayManager

        if (displayManager != null){
            //val presentationDisplays = displayManager?.getDisplays(DisplayManager.DISPLAY_CATEGORY_PRESENTATION)
            val presentationDisplays = displayManager?.displays

            Log.i("MAIN ACTIVITY", "Number od screens is: "+  presentationDisplays?.size)
            if (presentationDisplays!!.size > 1) {
                val secondActivity = SecondActivity(this@MainActivity, presentationDisplays[1])
                secondActivity.show()
            }
        }
    }
}
