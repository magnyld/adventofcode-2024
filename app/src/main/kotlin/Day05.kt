
fun checkRules(update: MutableList<Int>, rules: List<List<Int>>): Boolean {

    var valid = true;
    rules.forEachIndexed { index, rule ->

        if (
            update.indexOf(rule[0]) == -1 ||
            update.indexOf(rule[1]) == -1 ||

            update.indexOf(rule[0]) < update.indexOf(rule[1])
        ) {

            valid = valid && true;

        } else {

            update.removeAt(update.indexOf(rule[0]))
            update.add(update.indexOf(rule[1]), rule[0])

            valid = valid && false;

        }

    }
    return valid;
}

fun day05() {
    var total_part1 = 0
    var total_part2 = 0


    var input = getResourceAsText("day05.txt")


    input = """
47|53
97|13
97|61
97|47
75|29
61|13
75|53
29|13
97|29
53|29
61|53
97|53
61|29
47|13
75|47
97|75
47|61
75|61
47|29
75|13
53|13

75,47,61,53,29
97,61,53,29,13
75,29,13
75,97,47,61,53
61,13,29
97,13,75,29,47
    """.trimIndent()


    val input_parts = input.split("\n\n")

    val rules = input_parts[0].split("\n").map { it.split("|").map { it.toInt() } }
    val updates = input_parts[1].split("\n").map { it.split(",").map { it.toInt() }.toMutableList() }.toMutableList()



    for ((index, update) in updates.withIndex()) {
        var valid = checkRules(update, rules)


        var midpos = (update[(update.size - 1) / 2]);


        if (valid) {
            total_part1 += midpos;
        } else {
            println(midpos);
            total_part2 += midpos;
        }
    }


    println(total_part1)
    println(total_part2) // too low 4633
}
