package Monsters.`Nivel 2`

import Monsters.`Nivel 1`.Monster

class Sacerdotisa : Monster
    (name = "Sacerdotisa Oriental",
    Alive = true,
    life = 70,
    lifeTotal = 70,
    attack = 25,
    defense = 14,
    gold = 80,
    xp = 55)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}