fun checkAdjacent(grid: List<List<Char>>, x: Int, y: Int): Int {
    val directions = listOf(
        Pair(-1, -1), Pair(0, -1), Pair(1, -1),
        Pair(-1, 0), Pair(1, 0),
        Pair(-1, 1), Pair(0, 1), Pair(1, 1)
    )

    val search = "XMAS"

    var found = 0

    directions.forEach { direction ->

        search.forEachIndexed { i, char ->
            val newX = x + direction.first * i
            val newY = y + direction.second * i

            if (newX >= 0 && newX < grid[0].size && newY >= 0 && newY < grid.size) {
                if (grid[newY][newX] != search[i]) {
                    return@forEach
                }
            } else {
                return@forEach
            }
        }

        found++;
    }

    return found
}

fun checkAdjacent_part2(grid: List<List<Char>>, x: Int, y: Int): Int {
 
/*
M.S
.A.
M.S

M.S
.A.
M.S
*/
    if (
        (
            (grid[y][x] == 'M' && grid[y+1][x+1] == 'A' && grid[y+2][x+2] == 'S') ||
            (grid[y][x] == 'S' && grid[y+1][x+1] == 'A' && grid[y+2][x+2] == 'M')
        )
        &&
        (
            (grid[y+2][x] == 'M' && grid[y+1][x+1] == 'A' && grid[y][x+2] == 'S') ||
            (grid[y+2][x] == 'S' && grid[y+1][x+1] == 'A' && grid[y][x+2] == 'M')
        )   
    ) {
        return 1;
    }
    return 0
}


fun day04() {
    var total_part1 = 0
    var total_part2 = 0

    var input = getResourceAsText("day04.txt")

//     input = """
// MMMSXXMASM
// MSAMXMSMSA
// AMXSXMAAMM
// MSAMASMSMX
// XMASAMXAMM
// XXAMMXXAMA
// SMSMSASXSS
// SAXAMASAAA
// MAMMMXMMMM
// MXMXAXMASX
//     """.trimIndent()


    val grid = input.split("\n").map { it.toList() }
    
    grid.forEachIndexed { y, row ->

        row.forEachIndexed { x, char ->
            total_part1 += checkAdjacent(grid, x, y);
            
            try {
                total_part2 += checkAdjacent_part2(grid, x, y);
            } catch (e: Exception) {
                //println(e)
            }
        }     
    }

    println(total_part1)
    println(total_part2)
}
