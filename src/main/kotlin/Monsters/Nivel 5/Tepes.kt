package Monsters.`Nivel 5`

import Monsters.`Nivel 1`.Monster

class Tepes : Monster
    (name = "Descendente de Tepes",
    Alive = true,
    life = 270,
    lifeTotal = 270,
    attack = 55,
    defense = 27,
    gold = 450,
    xp = 280)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}