package Monsters.`Nivel 4`

import Monsters.`Nivel 1`.Monster

class Valkyria : Monster
    (name = "Valkyria",
    Alive = true,
    life = 180,
    lifeTotal = 180,
    attack = 48,
    defense = 23,
    gold = 300,
    xp = 180)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}