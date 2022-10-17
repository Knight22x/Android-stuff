package com.example.myapplication4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.myapplication4.databinding.ActivityMotionLayoutBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMotionLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMotionLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        initClickListeners()
    }

    private fun initClickListeners() {
        binding.apply {
            fab1.setOnClickListener {
                tv1.isVisible = !tv1.isVisible
                tv2.isVisible = !tv2.isVisible
                tv3.isVisible = !tv3.isVisible

                fab1.setImageResource(
                    if (tv1.isVisible) {
                        R.drawable.ic_visible
                    } else {
                        R.drawable.ic_invisible
                    }
                )
            }

            fab2.setOnClickListener {
                tv1.isInvisible = !tv1.isInvisible
                tv2.isInvisible = !tv2.isInvisible
                tv3.isInvisible = !tv3.isInvisible

                fab2.setImageResource(
                    if (tv1.isVisible) {
                        R.drawable.ic_visible
                    } else {
                        R.drawable.ic_invisible
                    }
                )
            }
        }
    }
}
