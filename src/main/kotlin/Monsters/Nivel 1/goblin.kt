package Monsters

import Monsters.`Nivel 1`.Monster

class goblin: Monster
    (name = "Goblin",
    Alive = true,
    life = 45,
    lifeTotal = 45,
    attack = 16,
    defense = 11,
    gold = 25,
    xp = 22)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }

}