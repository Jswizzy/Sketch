package com.arrowmaker.sketch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import processing.android.CompatUtils
import processing.android.PFragment
import processing.core.PApplet

class MainActivity : AppCompatActivity() {

    private lateinit var sketch: PApplet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sketch = Sketch()

        val frame =
                FrameLayout(this).apply {
                    id = CompatUtils.getUniqueViewId()
                }.also { layout ->
                    setContentView(
                            layout,
                            ViewGroup.LayoutParams(
                                    ViewGroup.LayoutParams.MATCH_PARENT,
                                    ViewGroup.LayoutParams.MATCH_PARENT))
                }

        PFragment(sketch)
                .setView(frame, this)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        sketch.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        sketch.onNewIntent(intent)
    }
}
