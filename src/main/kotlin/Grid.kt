import kotlin.math.ceil

class Grid(
    private val cells: String,
    private val width: Int
) {

    fun getNeighboursOf(cell: Cell): List<Char> {
        val hasPrevRow = cell.y - 1 >= 0
        val hasNextRow = cell.y + 1 < divideAndCeil(cells.length, width)
        val hasPrevCol = cell.x - 1 >= 0
        val hasNextCol = cell.x + 1 < width

        val neighbourCells = mutableListOf<Cell>()

        if (hasPrevRow) {
            neighbourCells.add(cell.copy(y = cell.y - 1))
            if (hasPrevCol) neighbourCells.add(cell.copy(y = cell.y - 1, x = cell.x - 1))
            if (hasNextCol) neighbourCells.add(cell.copy(y = cell.y - 1, x = cell.x + 1))
        }
        if (hasPrevCol) neighbourCells.add(cell.copy(x = cell.x - 1))
        if (hasNextCol) neighbourCells.add(cell.copy(x = cell.x + 1))
        if (hasNextRow) {
            neighbourCells.add(cell.copy(y = cell.y + 1))
            if (hasPrevCol) neighbourCells.add(cell.copy(y = cell.y + 1, x = cell.x - 1))
            if (hasNextCol) neighbourCells.add(cell.copy(y = cell.y + 1, x = cell.x + 1))
        }

        return neighbourCells.map { cells[it.y * width + it.x] }
    }

    private fun divideAndCeil(dividend: Int, divisor: Int): Int {
        return ceil(dividend.toDouble() / divisor.toDouble()).toInt()
    }
}