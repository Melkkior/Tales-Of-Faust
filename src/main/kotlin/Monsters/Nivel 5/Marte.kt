package Monsters.`Nivel 5`

import Monsters.`Nivel 1`.Monster

class Marte : Monster
    (name = "Marte",
    Alive = true,
    life = 340,
    lifeTotal = 340,
    attack = 68,
    defense = 24,
    gold = 600,
    xp = 350)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}