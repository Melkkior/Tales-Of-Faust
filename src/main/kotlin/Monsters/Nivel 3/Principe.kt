package Monsters.`Nivel 3`

import Monsters.`Nivel 1`.Monster

class Principe : Monster
    (name = "Principe Cego",
    Alive = true,
    life = 130,
    lifeTotal = 130,
    attack = 38,
    defense = 18,
    gold = 180,
    xp = 105)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}