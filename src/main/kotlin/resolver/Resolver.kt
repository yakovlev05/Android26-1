package resolver

import model.Player
import model.PlayerPosition
import model.Team

class Resolver(val players: List<Player>) : IResolver {

    override fun getCountWithoutAgency(): Int {
        return players.count { it.agency.isBlank() }
    }

    override fun getBestScorerDefender(): Pair<String, Int> {
        return players.filter { it.position == PlayerPosition.DEFENDER }
            .sortedByDescending { it.goals }
            .map { it.name to it.goals }
            .first()
    }

    override fun getTheExpensiveGermanPlayerPosition(): String {
        return players.filter { it.nationality == "Germany" }
            .maxByOrNull { it.transferCost }?.position?.russianName
            ?: throw NoSuchElementException("Player not found")
    }

    override fun getTheRudestTeam(): Team {
        return players.groupBy { it.team }
            .maxByOrNull { (_, teamPlayers) -> teamPlayers.sumOf { it.redCards }.toDouble() / teamPlayers.size }
            ?.key ?: throw NoSuchElementException("Team not found")
    }

}
