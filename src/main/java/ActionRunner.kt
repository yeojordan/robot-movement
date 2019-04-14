/**
 * Call appropriate command on the [Position] instance.
 */
object ActionRunner
{
    // Regex capture group pattern for PLACE command
    private val regexPattern = "PLACE (\\d),(\\d),(NORTH|SOUTH|EAST|WEST)".toRegex()
    var position: Position? = null

    /**
     * Perform actions on the robot.
     */
    fun runActions(moves: List<String>)
    {
        moves.forEach { callAction(it) }
    }

    /**
     * Call the correct action.
     *
     * @param action Action to perform on the robot.
     */
    private fun callAction(action: String)
    {
        when
        {
            action == "MOVE" -> position?.move()
            action == "LEFT" -> position?.rotateLeft()
            action == "RIGHT" -> position?.rotateRight()
            action == "REPORT" -> position?.report()
            action.contains("PLACE") ->
            {
                // Perform regex match group
                val capture = regexPattern.matchEntire(action)

                // Capture group will contain the entire string and the 3 groups expected
                if (capture != null && capture.groupValues.size == 4)
                {
                    val x = Integer.parseInt(capture.groupValues[1])
                    val y = Integer.parseInt(capture.groupValues[2])
                    val dir = capture.groupValues[3]
                    val direction = calcDirection(dir)

                    if ((x in 0..4) && (y in 0..4) && (direction != null))
                    {
                        this.position = Position(x, y, direction)
                    }
                }
            }
        }
    }

    /**
     * Convert the string retrieved for direction to its equivalent enum.
     *
     * @param dir Direction string.
     * @return The converted [Direction] enum.
     */
    private fun calcDirection(dir: String): Direction?
    {
        return when (dir)
        {
            "NORTH" -> Direction.NORTH
            "SOUTH" -> Direction.SOUTH
            "EAST" -> Direction.EAST
            "WEST" -> Direction.WEST
            else -> null
        }
    }
}