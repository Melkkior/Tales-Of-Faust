package Monsters.`Nivel 4`

import Monsters.`Nivel 1`.Monster

class Golem : Monster
    (name = "Golem",
    Alive = true,
    life = 220,
    lifeTotal = 220,
    attack = 42,
    defense = 22,
    gold = 250,
    xp = 160)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}