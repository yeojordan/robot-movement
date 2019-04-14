/**
 * Data class to represent the position of the robot on the table.
 *
 * @param x Horizontal position.
 * @param y Vertical position.
 * @param dir Direction robot is facing.
 */
data class Position(private var x: Int = 0,
                    private var y: Int = 0,
                    private var dir: Direction = Direction.NORTH)
{
    private val limit = 5

    /**
     * Move one unit in the current direction.
     * Movements that will result in an invalid position will be ignored.
     */
    fun move()
    {
        when (dir)
        {
            Direction.NORTH ->
            {
                if ((y + 1) < limit)
                {
                    y++
                }
            }
            Direction.SOUTH ->
            {
                if ((y - 1) >= 0)
                {
                    y--
                }
            }
            Direction.WEST ->
            {
                if (x - 1 >= 0)
                {
                    x--
                }
            }
            Direction.EAST ->
            {
                if (x + 1 < limit)
                {
                    x++
                }
            }
        }
    }

    /**
     * Rotate left by 90 degrees.
     */
    fun rotateLeft()
    {
        dir = when (dir)
        {
            Direction.NORTH -> Direction.WEST
            Direction.SOUTH -> Direction.EAST
            Direction.WEST -> Direction.SOUTH
            Direction.EAST -> Direction.NORTH
        }
    }

    /**
     * Rotate right by 90 degrees.
     */
    fun rotateRight()
    {
        dir = when (dir)
        {
            Direction.NORTH -> Direction.EAST
            Direction.SOUTH -> Direction.WEST
            Direction.WEST -> Direction.NORTH
            Direction.EAST -> Direction.SOUTH
        }
    }

    /**
     * Print the current position.
     */
    fun report()
    {
        println("X: $x, Y: $y, Direction: $dir")
    }
}

/**
 * Enum representing the direction the robot is facing.
 */
enum class Direction
{
    NORTH, SOUTH, EAST, WEST
}
