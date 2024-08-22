package com.example.guessthecolor

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guessthecolor.databinding.ActivityGameOverBinding
import com.example.guessthecolor.databinding.ActivitySplashBinding

class SplashMainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val colors = listOf("Vermelho", "Azul", "Verde", "Amarelo", "Preto", "Branco")
    private lateinit var correctColor: String
    private var attempts = 0
    private val maxAttempts = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)  // Certifique-se de usar o layout correto

        val colorTextView: TextView = findViewById(R.id.colorTextView)

        // Cria uma lista de botões com base nos IDs definidos no layout XML
        val buttons = listOf<Button>(
            findViewById(R.id.buttonRed),
            findViewById(R.id.buttonBlue),
            findViewById(R.id.buttonGreen),
            findViewById(R.id.buttonYellow),
            findViewById(R.id.buttonBlack),
            findViewById(R.id.buttonWhite)
        )

        // Função para configurar o jogo
        fun setupGame() {
            correctColor = colors.random()
            val displayedColor = colors.filter { it != correctColor }.random()

            colorTextView.text = correctColor
            colorTextView.setTextColor(getColorForName(displayedColor))
        }

        // Configura um listener de clique para cada botão na lista
        buttons.forEach { button ->
            button.setOnClickListener {
                attempts++
                val selectedColor = button.text.toString()
                // Verifica se a cor selecionada é a correta
                if (selectedColor == correctColor) {
                    Toast.makeText(this, "Parabéns! Você acertou!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java) // Volta para a tela inicial
                    startActivity(intent)
                    finish()
                } else {
                    // Mostra uma mensagem de erro com a cor correta
                    Toast.makeText(
                        this,
                        "Errado! A cor correta era $correctColor.",
                        Toast.LENGTH_SHORT
                    ).show()
                    // Verifica se o número máximo de tentativas foi alcançado
                    if (attempts >= maxAttempts) {
                        val intent = Intent(
                            this,
                            GameOverMainActivity2::class.java
                        )  // Se sim, vai para a tela de Game Over
                        startActivity(intent)
                        finish()
                    } else {
                        // Se não, configura o jogo novamente
                        setupGame()
                    }
                }
            }
        }

        setupGame()
    }

    private fun getColorForName(colorName: String): Int {
        return when (colorName) {
            "Vermelho" -> Color.RED
            "Azul" -> Color.BLUE
            "Verde" -> Color.GREEN
            "Amarelo" -> Color.YELLOW
            "Preto" -> Color.BLACK
            "Branco" -> Color.WHITE
            else -> Color.BLACK
        }
    }
}


