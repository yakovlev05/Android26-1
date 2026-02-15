package parser

import model.Player
import model.PlayerPosition
import model.Team
import java.io.File

object CsvParser {

    private const val DELIMITER = ";";

    fun parsePlayers(path: String): List<Player> {
        return File(path).readLines()
            .drop(1)
            .map { buildPlayer(it) }
            .toList()
    }

    private fun buildPlayer(line: String): Player {
        val lineSplit = line.split(DELIMITER)


        return Player(
            name = lineSplit[0],
            position = PlayerPosition.valueOf(lineSplit[3]),
            nationality = lineSplit[4],
            agency = lineSplit[5],
            transferCost = lineSplit[6].toInt(),
            participations = lineSplit[7].toInt(),
            goals = lineSplit[8].toInt(),
            assists = lineSplit[9].toInt(),
            yellowCards = lineSplit[10].toInt(),
            redCards = lineSplit[11].toInt(),
            team = buildTeam(lineSplit),
        )
    }

    private fun buildTeam(lineSplit: List<String>): Team {
        return Team(
            name = lineSplit[1],
            city = lineSplit[2],
        )
    }
}
