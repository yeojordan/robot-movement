import org.junit.Assert
import org.junit.Test

class PositionTest
{
    @Test
    fun testRotateLeft()
    {
        val position = Position()
        position.rotateLeft()

        Assert.assertEquals(Position(dir = Direction.WEST), position)
    }

    @Test
    fun testRotateRight()
    {
        val position = Position()
        position.rotateRight()

        Assert.assertEquals(Position(dir = Direction.EAST), position)
    }

    @Test
    fun testMoveOutsideBoundary()
    {
        val position = Position(0, 4, Direction.NORTH)
        position.move()

        // Expect no change.
        Assert.assertEquals(position, position)
    }

    @Test
    fun testMove()
    {
        val position = Position(0, 1, Direction.EAST)
        position.move()

        // Expect no change.
        Assert.assertEquals(Position(1, 1, dir = Direction.EAST), position)
    }
}
