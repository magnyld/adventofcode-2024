import kotlin.math.abs
import java.util.Collections

fun day01() {

    val input = getResourceAsText("day01.txt")

    // val input = """
    // 3   4
    // 4   3
    // 2   5
    // 1   3
    // 3   9
    // 3   3
    // """.trimIndent()
 
    val listA = mutableListOf<Int>()
    val listB = mutableListOf<Int>()

    input.split("\n").forEach {
        val data = it.split("   ").map { it.toInt() }
        listA.add(data[0])
        listB.add(data[1])
    }

    val listASorted = listA.sorted()
    val listBSorted = listB.sorted()

    var total = 0
    var total_step2 = 0
    
    listASorted.forEachIndexed { index, item ->

        val diff = abs(listASorted[index] - listBSorted[index])
        total += diff

        val count = Collections.frequency(listBSorted, item)
        total_step2 += count * item
    }

    println(total)
    println(total_step2)
}
