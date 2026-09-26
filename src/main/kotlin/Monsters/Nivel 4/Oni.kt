package Monsters.`Nivel 4`

import Monsters.`Nivel 1`.Monster

class Oni : Monster
    (name = "200",
    Alive = true,
    life = 200,
    lifeTotal = 200,
    attack = 52,
    defense = 20,
    gold = 280,
    xp = 190)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}