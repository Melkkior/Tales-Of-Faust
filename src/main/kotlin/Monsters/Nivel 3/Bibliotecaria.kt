package Monsters.`Nivel 3`

import Monsters.`Nivel 1`.Monster

class Bibliotecaria: Monster
    (name = "Bibliotecaria Cansada",
    Alive = true,
    life = 95,
    lifeTotal = 95,
    attack = 30,
    defense = 19,
    gold = 110,
    xp = 75)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}