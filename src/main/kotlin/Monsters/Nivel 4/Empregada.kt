package Monsters.`Nivel 4`

import Monsters.`Nivel 1`.Monster

class Empregada : Monster
    (name = "Empregada",
    Alive = true,
    life = 155,
    lifeTotal = 155,
    attack = 45,
    defense = 24,
    gold = 350,
    xp = 175)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}