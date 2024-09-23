package com.example.uprapp

import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var listbtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listbtn= findViewById(R.id.btn)
        val D:AnimationDrawable= listbtn.background as AnimationDrawable

        D.setEnterFadeDuration(1800)
        D.setExitFadeDuration(2000)
        D.start()

        val txt= findViewById<TextView>(R.id.welcometxt)
        val p= txt.paint
        val width=p.measureText(txt.text.toString())

        txt.paint.shader=LinearGradient(
            0f,0f,width,txt.textSize, intArrayOf(
                Color.parseColor("#FF0000"),
                Color.parseColor("#ffff00"),
                Color.parseColor("#99ff99")
            ),null,Shader.TileMode.REPEAT
        )

        listbtn.setOnClickListener{
            startActivity(Intent(this,profilelistActivity::class.java))
            finish()
        }



    }
}