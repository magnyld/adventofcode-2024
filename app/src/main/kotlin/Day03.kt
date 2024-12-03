fun getTotalValidMul(input: String): Int {

    var total = 0
    val regexp = Regex("mul\\(\\d+,\\d+\\)")

    val matches = regexp.findAll(input)

    for (match in matches) {
        //println("Full match: ${match.value}")
        val values = match.value.substring(4,match.value.length-1).split(",").map { it.toInt() }
        
        total += values[0] * values[1]    
    }

    return total;
}

fun day03() {
    var total_part1 = 0
    var total_part2 = 0

    var input = getResourceAsText("day03.txt")

    // val input_part1 = """
    // xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))
    // """.trimIndent()
    // input = input_part1;

    // var input_part2 = """
    // xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))
    // """.trimIndent()
    // input = input_part2;

    total_part1 = getTotalValidMul(input)

    var input_part2 = "do()" + input + "don't()"
        
    val regexp_do = Regex("do\\(\\)(.*?)don't\\(\\)")
    val matches_do = regexp_do.findAll(input_part2)

    for (match in matches_do) {
        var input_part = match.groups[1]?.value?.trim()
        total_part2 += getTotalValidMul(input_part!!)
    }

    println(total_part1)
    println(total_part2)
}
