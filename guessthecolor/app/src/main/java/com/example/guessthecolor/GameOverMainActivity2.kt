package com.example.guessthecolor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.guessthecolor.databinding.ActivityGameOverBinding

class GameOverMainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityGameOverBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        // Declarando e inicializando as variáveis
        val retryButton: Button = findViewById(R.id.retryButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        // Configurando o listener para o botão de retry
        retryButton.setOnClickListener {
            val intent = Intent(this, SplashMainActivity2::class.java)
            startActivity(intent)
            finish()
        }

        // Configurando o listener para o botão de exit
        exitButton.setOnClickListener {
            finishAffinity() // Fecha todas as atividades da pilha de tarefas
        }
    }
}
