package var1

import model.Player
import org.jetbrains.kotlinx.dataframe.api.dataFrameOf
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.letsplot.export.save
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.layers.pie
import org.jetbrains.kotlinx.kandy.letsplot.style.Style

/**
 * Покажите, какую долю от всех игроков занимают игроки каждой из позиций (защитник, нападающий и тд).
 */
object PositionFrequencyChart {

    fun save(players: List<Player>) {
        val positionToPlayers = players.groupBy { it.position.russianName }

        val positions = positionToPlayers.keys.toList()
        val counts = positionToPlayers.values.map { it.size }

        val df = dataFrameOf(
            "Position" to positions,
            "Count" to counts
        )

        df.plot {
            pie {
                slice("Count")
                fillColor("Position")
            }
            layout {
                style(Style.Void)
            }
        }.save("plot.png")
    }

}
