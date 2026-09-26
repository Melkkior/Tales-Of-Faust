package Monsters.`Nivel 3`

import Monsters.`Nivel 1`.Monster

class China : Monster
    (name = "Garota Chinesa",
    Alive = true,
    life = 105,
    lifeTotal = 105,
    attack = 32,
    defense = 18,
    gold = 120,
    xp = 90)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}