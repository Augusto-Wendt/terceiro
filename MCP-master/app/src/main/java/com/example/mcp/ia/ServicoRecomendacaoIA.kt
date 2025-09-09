// app/src/main/java/com/example/assistentebebidas/ia/ServicoRecomendacaoIA.kt

package com.example.assistentebebidas.ia

import com.example.assistentebebidas.data.ContextoRecomendacao // Importar a classe de contexto

/**
 * Este serviço simula a lógica de Inteligência Artificial.
 * Ele recebe o Contexto (MCP) e gera uma recomendação.
 * Em um sistema real, isso seria um modelo de ML treinado (TensorFlow Lite, por exemplo).
 */
class ServicoRecomendacaoIA {

    fun recomendarBebida(contexto: ContextoRecomendacao): String {
        // Em um app Android, você usaria Log.d para depurar
        android.util.Log.d("ServicoRecomendacaoIA", "Contexto recebido: ${contexto.exibirContexto()}")

        return when {
            // Regra 1: Quente e buscando algo doce
            contexto.temperaturaAmbienteCelsius >= 25 && contexto.preferenciaUsuario == "doce" && !contexto.estaChovendo ->
                "Sugerimos um Milkshake de Chocolate!"

            // Regra 2: Quente e buscando algo refrescante
            contexto.temperaturaAmbienteCelsius >= 25 && contexto.preferenciaUsuario == "refrescante" && !contexto.estaChovendo ->
                "Que tal uma Água de Coco gelada?"

            // Regra 3: Frio, úmido e chovendo
            contexto.temperaturaAmbienteCelsius < 15 && contexto.umidadeRelativa > 70 && contexto.estaChovendo ->
                "Perfeito para um Cappuccino cremoso!"

            // Regra 4: Frio, mas sem chuva
            contexto.temperaturaAmbienteCelsius < 15 && !contexto.estaChovendo ->
                "Um Chá de Gengibre seria ótimo para aquecer!"

            // Regra 5: Temperatura amena (primavera/outono) e doce
            contexto.temperaturaAmbienteCelsius in 15..24 && contexto.preferenciaUsuario == "doce" ->
                "Um Suco de Laranja com Morango é uma boa pedida."

            // Regra 6: Temperatura amena e refrescante
            contexto.temperaturaAmbienteCelsius in 15..24 && contexto.preferenciaUsuario == "refrescante" ->
                "Experimente um Chá Gelado de Pêssego."

            // Regra Padrão: Se nenhuma regra específica se aplica
            else -> "Que tal uma Água Mineral? Mantenha-se hidratado!"
        }
    }
}