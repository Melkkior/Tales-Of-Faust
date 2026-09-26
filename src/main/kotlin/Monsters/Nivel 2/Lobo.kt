package Monsters.`Nivel 2`

import Monsters.`Nivel 1`.Monster

class Lobo : Monster
    (name = "Lobo",
    Alive = true,
    life = 75,
    lifeTotal = 75,
    attack = 23,
    defense = 15,
    gold = 35,
    xp = 40)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}