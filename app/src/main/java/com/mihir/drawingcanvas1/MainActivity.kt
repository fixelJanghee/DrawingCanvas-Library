package com.mihir.drawingcanvas1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.mihir.drawingcanvas1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val colorArray by lazy {
        arrayOf(
            R.color.purple_200, R.color.purple_500, R.color.purple_700, R.color.teal_200, R.color.teal_700,
            R.color.black, R.color.white
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            undo.setOnClickListener {
                drawing.undo()
            }

            redo.setOnClickListener {
                drawing.redo()
            }

            delete.setOnClickListener {
                drawing.clearDrawingBoard()
            }

            brush.setOnClickListener {
                drawing.setSizeForBrush((5..20).random())
                drawing.setBrushAlpha((0..200).random())
            }

            custom.setOnClickListener {
                val id = colorArray.random()
                drawing.setBrushColor(ContextCompat.getColor(this@MainActivity, id))
            }
        }

    }
}