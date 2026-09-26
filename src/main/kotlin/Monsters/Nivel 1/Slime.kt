package Monsters

import Monsters.`Nivel 1`.Monster

class Slime: Monster
    (name = "Slime",
    Alive = true,
    life = 60,
    lifeTotal = 60,
    attack = 10,
    defense = 8,
    gold = 12,
    xp = 20)
    {
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}