package com.example.MAD_practical_9_21012021049
import  android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var imageanimation : AnimationDrawable
    lateinit var logoimage : ImageView
    lateinit var logoanimation : Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        logoimage=findViewById(R.id.uvpce)
        logoimage.setBackgroundResource((R.drawable.uvpce_logo_animation))
        imageanimation = logoimage.background as AnimationDrawable
        logoanimation= AnimationUtils.loadAnimation(this, R.anim.twin_animation)
        logoanimation.setAnimationListener(this)
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            imageanimation.start()
            logoimage.startAnimation(logoanimation)
        }
        else {
            imageanimation.stop()

        }
    }
    override fun onAnimationStart(p0: Animation?) {
    }
    override fun onAnimationEnd(p0: Animation?) {
        Intent(this, MainActivity::class.java).apply { startActivity(this) }
    }
    override fun onAnimationRepeat(p0: Animation?) {
    }
}
