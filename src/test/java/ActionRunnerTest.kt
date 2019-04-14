import org.junit.Assert
import org.junit.Test

class ActionRunnerTest
{
    @Test
    fun testSimpleMove()
    {
        /*
        PLACE 0,0,NORTH
        MOVE
        REPORT
        Output: 0,1,NORTH
         */
        ActionRunner.runActions(listOf("PLACE 0,0,NORTH", "MOVE", "REPORT"))
        Assert.assertEquals(Position(0, 1, Direction.NORTH), ActionRunner.position)
    }

    @Test
    fun testRotation()
    {
        /*
        PLACE 0,0,NORTH
        LEFT
        REPORT
        Output: 0,0,WEST
        */
        ActionRunner.runActions(listOf("PLACE 0,0,NORTH", "LEFT", "REPORT"))
        Assert.assertEquals(Position(0, 0, Direction.WEST), ActionRunner.position)
    }

    @Test
    fun testCombination()
    {
        /*
        PLACE 1,2,EAST
        MOVE
        MOVE
        LEFT
        MOVE
        REPORT
        Output: 3,3,NORTH
        */

        ActionRunner.runActions(listOf("PLACE 1,2,EAST", "MOVE", "MOVE", "LEFT", "MOVE", "REPORT"))
        Assert.assertEquals(Position(3, 3, Direction.NORTH), ActionRunner.position)
    }

    @Test
    fun testMultiplePlacements()
    {
        /*
        PLACE 1,2,EAST
        MOVE
        MOVE
        LEFT
        PLACE 0,0,EAST
        MOVE
        REPORT
        Output: 3,3,NORTH
        */
        ActionRunner.runActions(listOf("PLACE 1,2,EAST", "MOVE", "MOVE",
                "LEFT", "PLACE 0,0,EAST", "MOVE", "REPORT"))

        Assert.assertEquals(Position(1, 0, Direction.EAST), ActionRunner.position)
    }

    @Test
    fun testInvalidMovement()
    {
        /*
        PLACE 0,0,WEST
        MOVE
        REPORT
        Output: 3,3,NORTH
        */
        ActionRunner.runActions(listOf("PLACE 0,0,WEST", "MOVE", "REPORT"))

        Assert.assertEquals(Position(0, 0, Direction.WEST), ActionRunner.position)
    }

    @Test
    fun testInvalidPlacement()
    {
        /*
        PLACE 7,7,WEST
        MOVE
        PLACE 0,1,NORTH
        REPORT
        Output: 0,1,NORTH
        */
        ActionRunner.runActions(listOf("PLACE 7,7,WEST", "MOVE", "PLACE 0,1,NORTH", "REPORT"))
        Assert.assertEquals(Position(0, 1, Direction.NORTH), ActionRunner.position)
    }
}