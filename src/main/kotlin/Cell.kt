class Cell(
    private val isAlive: Boolean,
    private val neighbours: Int
) {

    fun getNextState(): Boolean {
        return when (neighbours) {
            2 -> isAlive
            3 -> true
            else -> false
        }
    }
}
