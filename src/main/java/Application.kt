import java.io.IOException

class Application
{
    companion object
    {
        @JvmStatic
        fun main(args: Array<String>)
        {
            if (args.isNotEmpty())
            {
                println("Running: ${args[0]}")
                try
                {
                    val file = Application::class.java.getResourceAsStream(args[0])
                            .bufferedReader()

                    // Retrieve lines and trim excess space
                    val moves = file.readLines().map { it.trim() }
                    ActionRunner.runActions(moves)
                }
                catch (e: IOException)
                {
                    println("Failed to read from input file ${args[0]}.")
                }
                catch (e: Exception)
                {
                    println("An unexpected error occurred. ${e.localizedMessage}")
                }
            }
            else
            {
                println("No input file specified.")
            }
        }
    }
}