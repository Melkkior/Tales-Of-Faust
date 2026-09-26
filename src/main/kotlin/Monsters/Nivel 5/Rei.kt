package Monsters.`Nivel 5`

import Monsters.`Nivel 1`.Monster

class Rei : Monster
    (name = "Rei dos mortos",
    Alive = true,
    life = 350,
    lifeTotal = 350,
    attack = 65,
    defense = 29,
    gold = 700,
    xp = 400)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}