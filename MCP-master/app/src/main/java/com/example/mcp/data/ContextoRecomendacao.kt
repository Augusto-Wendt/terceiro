// app/src/main/java/com/example/assistentebebidas/data/ContextoRecomendacao.kt

package com.example.assistentebebidas.data

/**
 * Esta é a nossa representação simplificada do Contexto do Modelo (MCP).
 * Ela define quais informações são relevantes para o nosso sistema de recomendação.
 */
data class ContextoRecomendacao(
    val temperaturaAmbienteCelsius: Int,
    val umidadeRelativa: Int,
    val estaChovendo: Boolean,
    val preferenciaUsuario: String // Ex: "doce", "refrescante", "quente"
) {
    // Método para exibir o contexto de forma legível (útil para logs ou debug)
    fun exibirContexto(): String {
        return """
        --- Contexto Atual ---
        Temperatura: ${temperaturaAmbienteCelsius}°C
        Umidade: ${umidadeRelativa}%
        Chovendo: ${if (estaChovendo) "Sim" else "Não"}
        Preferência: $preferenciaUsuario
        --------------------
        """.trimIndent()
    }
}