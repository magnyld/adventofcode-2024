import kotlin.math.abs
import java.util.Collections


fun checkInc(index: Int, level: List<Int>): Boolean {
    if (level[index] < level[index + 1] && (level[index + 1] - level[index] <= 3)) {
        return true;
    }
    return false;
}

fun checkDec(index: Int, level: List<Int>): Boolean {
    
    if (level[index] > level[index + 1] && (level[index] - level[index + 1] <= 3)) {
        return true;
    }
    return false;
}

fun checkLevel(level: List<Int>): Boolean {
    var safeInc = true;
    var safeDec = true;
    
    level.forEachIndexed { index, item ->
        if(level.size - 1 == index) {
            return@forEachIndexed
        }

        safeInc = safeInc && checkInc(index, level)
        safeDec = safeDec && checkDec(index, level)
    }

    if (safeInc || safeDec) {
        return true;
    } 
    return false;
}


fun day02() {

    val input = getResourceAsText("day02.txt")

    // val input = """
    // 7 6 4 2 1
    // 1 2 7 8 9
    // 9 7 6 2 1
    // 1 3 2 4 5
    // 8 6 4 4 1
    // 1 3 6 7 9
    // """.trimIndent()
 
    var total_part1 = 0
    var total_part2 = 0

    input.split("\n").forEach { report ->
        val level = report.split(" ").map { it.toInt() }
        
        if(checkLevel(level)) {
            total_part1++
        } else {

            level.toMutableList().forEachIndexed { index, item ->
                val mutableLevel = level.toMutableList()
                mutableLevel.removeAt(index)
                if (checkLevel(mutableLevel)) {
                    total_part2++
                    return@forEach
                }
            }

        }
    }

    println(total_part1)
    println(total_part1 + total_part2);
}
