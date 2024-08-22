
package com.example.guessthecolor ;

import android.app.Activity ;
import android.content.Intent ;
import android.os.Bundle ;
import android.view.View ;
import android.widget.Button ;
import androidx.appcompat.app.AppCompatActivity ;
import com.example.guessthecolor.databinding.ActivityGameOverBinding
import com.example.guessthecolor.databinding.ActivityMainBinding
import com.example.guessthecolor.databinding.ActivitySplashBinding

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declarando o `Button`
        val startButton: Button = findViewById(R.id.startButton)
        startButton.setOnClickListener {
            // Iniciando a nova Activity
            val intent = Intent(this, SplashMainActivity2::class.java)
            startActivity(intent)
            finish()
        }
    }
}





