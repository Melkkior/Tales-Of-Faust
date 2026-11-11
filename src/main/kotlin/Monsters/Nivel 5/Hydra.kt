package Monsters.`Nivel 5`

import Monsters.`Nivel 1`.Monster

class Hydra : Monster
    (name = "Hydra",
    Alive = true,
    life = 300,
    lifeTotal = 300,
    attack = 60,
    defense = 25,
    gold = 500,
    xp = 300)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}