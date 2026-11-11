package Monsters.`Nivel 1`

abstract class Monster(
    val name: String,
    var life: Int,
    val lifeTotal: Int,
    val defense: Int,
    var Alive: Boolean,
    val attack: Int,
    val xp: Int,
    val gold: Int
)
{
    abstract fun Atacar(DefF: Int): Int
}