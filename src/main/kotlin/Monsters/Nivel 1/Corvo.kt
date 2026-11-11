package Monsters

import Monsters.`Nivel 1`.Monster

class Corvo: Monster
    (
    name = "Corvo",
    Alive = true,
    life = 24,
    lifeTotal = 24,
    attack = 12,
    defense = 14,
    gold = 10,
    xp = 15
    )
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}