// app/src/main/java/com/example/assistentebebidas/MainActivity.kt

package com.example.assistentebebidas

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assistentebebidas.data.ContextoRecomendacao
import com.example.assistentebebidas.ia.ServicoRecomendacaoIA

class MainActivity : AppCompatActivity() {

    private lateinit var tvRecomendacao: TextView
    private val servicoIA = ServicoRecomendacaoIA()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Define o layout da tela

        // Inicializa a TextView que exibirá a recomendação
        tvRecomendacao = findViewById(R.id.tvRecomendacao)

        // Configura os botões para simular os cenários
        findViewById<Button>(R.id.btnCenario1).setOnClickListener {
            simularCenario1()
        }
        findViewById<Button>(R.id.btnCenario2).setOnClickListener {
            simularCenario2()
        }
        findViewById<Button>(R.id.btnCenario3).setOnClickListener {
            simularCenario3()
        }
        findViewById<Button>(R.id.btnCenario4SantaCruz).setOnClickListener {
            simularCenario4SantaCruz()
        }
    }

    private fun simularCenario1() {
        val contexto = ContextoRecomendacao(
            temperaturaAmbienteCelsius = 28,
            umidadeRelativa = 60,
            estaChovendo = false,
            preferenciaUsuario = "refrescante"
        )
        val recomendacao = servicoIA.recomendarBebida(contexto)
        tvRecomendacao.text = "Recomendação para você: $recomendacao"
    }

    private fun simularCenario2() {
        val contexto = ContextoRecomendacao(
            temperaturaAmbienteCelsius = 12,
            umidadeRelativa = 85,
            estaChovendo = true,
            preferenciaUsuario = "quente"
        )
        val recomendacao = servicoIA.recomendarBebida(contexto)
        tvRecomendacao.text = "Recomendação para você: $recomendacao"
    }

    private fun simularCenario3() {
        val contexto = ContextoRecomendacao(
            temperaturaAmbienteCelsius = 20,
            umidadeRelativa = 70,
            estaChovendo = false,
            preferenciaUsuario = "doce"
        )
        val recomendacao = servicoIA.recomendarBebida(contexto)
        tvRecomendacao.text = "Recomendação para você: $recomendacao"
    }

    private fun simularCenario4SantaCruz() {
        // Em 26 de junho em Santa Cruz do Sul, a tendência é de clima ameno para frio.
        // Vamos simular um dia típico de inverno na região.
        val contexto = ContextoRecomendacao(
            temperaturaAmbienteCelsius = 14, // Temperatura média de inverno em 26 de junho
            umidadeRelativa = 75,
            estaChovendo = false,
            preferenciaUsuario = "quente"
        )
        val recomendacao = servicoIA.recomendarBebida(contexto)
        tvRecomendacao.text = "Recomendação para você em Santa Cruz do Sul: $recomendacao"
    }
}