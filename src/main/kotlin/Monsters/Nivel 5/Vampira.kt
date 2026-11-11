package Monsters.`Nivel 5`

import Monsters.`Nivel 1`.Monster

class Vampira : Monster
    (name = "Vampira Esquecida",
    Alive = true,
    life = 300,
    lifeTotal = 300,
    attack = 62,
    defense = 28,
    gold = 700,
    xp = 325)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}