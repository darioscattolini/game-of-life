class GameOfLife {
    /**
    seed 16 character string. Containing * (alive cells) or - (dead cells)
     */
    private fun getNextGeneration(seed: String): String {
        val gridSeed = seed.split('\n')
        val output = gridSeed.mapIndexed { rowIndex, row ->
            row.mapIndexed { colIndex, cell ->
                val neighbours = countNeighbours(gridSeed, rowIndex, colIndex)
                getNextCellState(cell, neighbours)
            }
        }
        return output.joinToString("\n") { it.joinToString("") }
    }

    private fun getNextCellState(cell: Char, neighbours: Int): Char {
        return when (neighbours) {
            2 -> if (cell == '*') '*' else '-'
            3 -> '*'
            else -> '-'
        }
    }

    private fun countNeighbours(grid: List<String>, row: Int, col: Int): Int {
        var count = 0
        if (grid[row].getOrNull(col - 1) == '*') count++
        if (grid[row].getOrNull(col + 1) == '*') count++
        if (grid.getOrNull(row - 1) != null) {
            if (grid[row - 1].getOrNull(col) == '*') count++
            if (grid[row - 1].getOrNull(col - 1) == '*') count++
            if (grid[row - 1].getOrNull(col + 1) == '*') count++
        }
        if (grid.getOrNull(row + 1) != null) {
            if (grid[row + 1].getOrNull(col) == '*') count++
            if (grid[row + 1].getOrNull(col - 1) == '*') count++
            if (grid[row + 1].getOrNull(col + 1) == '*') count++
        }
        return count
    }

    fun play (seed: String){
       val nextGeneration = getNextGeneration(seed)
        println("$nextGeneration \n\n")
        if (nextGeneration.contains('*')) play(nextGeneration)
    }
}


fun main() {
    val gameOfLife = GameOfLife()
    gameOfLife.play("""
   |****
   |-*--
   |--–-
   |--*-
  """.trimMargin())
}

/* Función pura: recibes un input y devuelves el mismo output -> programación funcional (código
más predecible y testeable */