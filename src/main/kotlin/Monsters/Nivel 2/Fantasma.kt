package Monsters.`Nivel 2`

import Monsters.`Nivel 1`.Monster

class Fantasma: Monster
    (name = "Espirito",
    Alive = true,
    life = 65,
    lifeTotal = 65,
    attack = 21,
    defense = 17,
    gold = 45,
    xp = 45)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}