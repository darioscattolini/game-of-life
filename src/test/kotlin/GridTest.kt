import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class GridTest {

    @Test
    fun `It returns the neighbour values of the center cell of a 3x3 grid`() {
        val grid = Grid("123456789", 3)
        val cellToBeChecked = Cell(1, 1)
        val expectedNeighbours = listOf('1', '2', '3', '4', '6', '7', '8', '9')

        val neighbours = grid.getNeighboursOf(cellToBeChecked)

        assertThat(neighbours).containsExactlyInAnyOrderElementsOf(expectedNeighbours)
    }

    @Test
    fun `It returns the neighbour values of one center cell of a 4x3 grid`() {
        val grid = Grid("12345678abcd", 4)
        val cellToBeChecked = Cell(2, 1)
        val expectedNeighbours = listOf('2', '3', '4', '6', '8', 'b', 'c', 'd')

        val neighbours = grid.getNeighboursOf(cellToBeChecked)

        assertThat(neighbours).containsExactlyInAnyOrderElementsOf(expectedNeighbours)
    }

    @ParameterizedTest
    @CsvSource(
        "0, 0, '245'",
        "1, 0, '13456'",
        "2, 0, '256'",
        "0, 1, '12578'",
        "2, 1, '23589'",
        "0, 2, '458'",
        "1, 2, '45679'",
        "2, 2, '568'"
    )
    fun `It returns expected neighbours for cells on edges`(x: Int, y: Int, expectedNeighbours: String) {
        val grid = Grid("123456789", 3)
        val cellToBeChecked = Cell(x, y)
        val expectedNeighboursChars = expectedNeighbours.toCharArray().toList()

        val neighbours = grid.getNeighboursOf(cellToBeChecked)

        assertThat(neighbours).containsExactlyInAnyOrderElementsOf(expectedNeighboursChars)
    }
}