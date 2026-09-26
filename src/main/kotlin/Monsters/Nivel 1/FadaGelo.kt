package Monsters

import Monsters.`Nivel 1`.Monster

class FadaGelo : Monster(
    name = "Fada de Gelo",
    Alive = true,
    life = 28,
    lifeTotal = 28,
    attack = 18,
    defense = 12,
    gold = 35,
    xp = 20
)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}