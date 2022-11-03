class NextGenerationCreator(private val currentGeneration: String) {
    fun create(): String {
        val gridSeed = currentGeneration.split('\n')
        val neighbourCounter = NeighbourCounter(gridSeed)

        val output = gridSeed.mapIndexed { rowIndex, row ->
            row.mapIndexed { colIndex, cellState ->
                val neighbours = neighbourCounter.countCellNeighbours(rowIndex, colIndex)
                val isAlive = cellState == '*'
                val nextState = Cell(isAlive, neighbours).getNextState()
                if (nextState) '*' else '-'
            }
        }

        return output.joinToString("\n") { it.joinToString("") }
    }
}
