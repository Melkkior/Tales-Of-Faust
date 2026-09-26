package Monsters

import Monsters.`Nivel 1`.Monster

class Prinny: Monster
    (name = "Prinny",
    Alive = true,
    life = 40,
    lifeTotal = 40,
    attack = 15,
    defense = 10,
    gold = 30,
    xp = 20)
    {
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}