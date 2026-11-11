package Monsters.`Nivel 2`

import Monsters.`Nivel 1`.Monster

class Bruxa : Monster
    (name = "Bruxa Ocidental",
    Alive = true,
    life = 68,
    lifeTotal = 68,
    attack = 27,
    defense = 16,
    gold = 90,
    xp = 55)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}