package Monsters.`Nivel 4`

import Monsters.`Nivel 1`.Monster

class Cultista : Monster
    (name = "Cultista",
    Alive = true,
    life = 145,
    lifeTotal = 145,
    attack = 50,
    defense = 18,
    gold = 220,
    xp = 150)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}