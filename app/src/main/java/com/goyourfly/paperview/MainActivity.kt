package com.goyourfly.paperview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import com.goyourfly.library.paper_view.PaperView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_large.*
import kotlinx.android.synthetic.main.item_small.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layout_small.setOnClickListener {
            paperView.unfold(true)
        }

        btn_close.setOnClickListener {
            paperView.fold(true)
        }

        seek_bar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                paperView.setDuration(progress.toLong())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        paperView.setStateChangedListener(object:PaperView.OnFoldStateChangeListener{
            override fun onFold() {
                Toast.makeText(this@MainActivity,"onFold",Toast.LENGTH_SHORT).show()
            }

            override fun onUnfold() {
                Toast.makeText(this@MainActivity,"onUnfold",Toast.LENGTH_SHORT).show()
            }
        })
    }
}
