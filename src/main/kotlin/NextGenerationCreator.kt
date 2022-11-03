class NextGenerationCreator(private val currentGeneration: String) {
    fun create(): String {
        val gridSeed = currentGeneration.split('\n')

        val output = gridSeed.mapIndexed { rowIndex, row ->
            row.mapIndexed { colIndex, cellState ->
                val neighbours = NeighbourCounter().countCellNeighbours(gridSeed, rowIndex, colIndex)
                val isAlive = cellState == '*'
                val nextState = Cell(isAlive, neighbours).getNextState()
                if (nextState) '*' else '-'
            }
        }

        return output.joinToString("\n") { it.joinToString("") }
    }
}
