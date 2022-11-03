class GameOfLife {
    fun play(seed: String) {
        val nextGeneration = NextGenerationCreator(seed).create()
        println("$nextGeneration \n\n")
        Thread.sleep(1_000)
        if (nextGeneration.contains('*')) play(nextGeneration)
    }
}


fun main() {
    val gameOfLife = GameOfLife()
    gameOfLife.play("""
        |----
        |-***
        |***-
        |----
    """.trimMargin())
}

/* Función pura: recibes un input y devuelves el mismo output -> programación funcional (código
más predecible y testeable */