class NeighbourCounter {
    fun countCellNeighbours(grid: List<String>, cellRow: Int, cellCol: Int): Int {
        var count = 0

        if (grid[cellRow].getOrNull(cellCol - 1) == '*') count++
        if (grid[cellRow].getOrNull(cellCol + 1) == '*') count++

        if (grid.getOrNull(cellRow - 1) != null) {
            if (grid[cellRow - 1].getOrNull(cellCol) == '*') count++
            if (grid[cellRow - 1].getOrNull(cellCol - 1) == '*') count++
            if (grid[cellRow - 1].getOrNull(cellCol + 1) == '*') count++
        }

        if (grid.getOrNull(cellRow + 1) != null) {
            if (grid[cellRow + 1].getOrNull(cellCol) == '*') count++
            if (grid[cellRow + 1].getOrNull(cellCol - 1) == '*') count++
            if (grid[cellRow + 1].getOrNull(cellCol + 1) == '*') count++
        }

        return count
    }

}
