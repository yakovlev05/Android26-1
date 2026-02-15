package model

class Player(
    val name: String,
    val position: PlayerPosition,
    val nationality: String,
    val agency: String,
    val transferCost: Int,
    val participations: Int,
    val goals: Int,
    val assists: Int,
    val yellowCards: Int,
    val redCards: Int,
    val team: Team,

)
