package Monsters.`Nivel 3`

import Monsters.`Nivel 1`.Monster

class Princesa : Monster
    (name = "Princesa Mentirosa",
    Alive = true,
    life = 120,
    lifeTotal = 120,
    attack = 35,
    defense = 17,
    gold = 150,
    xp = 90)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}