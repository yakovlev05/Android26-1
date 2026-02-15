import parser.CsvParser.parsePlayers
import resolver.Resolver
import var1.PositionFrequencyChart

fun main() {
    val players = parsePlayers("src/main/resources/fakePlayers.csv")
    val resolver = Resolver(players)
    printAnswer(resolver)

    PositionFrequencyChart.save(players)
}


fun printAnswer(resolver: Resolver) {
    println("Количество игроков, интересы которых не представляет агенство: ${resolver.getCountWithoutAgency()}")
    println("Автор наибольшего числа голов из числа защитников и их количество: ${resolver.getBestScorerDefender()}")
    println("Русское название позиции самого дорогого немецкого игрока ${resolver.getTheExpensiveGermanPlayerPosition()}")
    println("Команда с наибольшим средним числом красных карточек на одного игрока ${resolver.getTheRudestTeam()}")
}
