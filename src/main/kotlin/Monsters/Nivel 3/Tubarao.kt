package Monsters.`Nivel 3`

import Monsters.`Nivel 1`.Monster

class Tubarao : Monster
    (name = "Pequeno Tubarão",
    Alive = true,
    life = 115,
    lifeTotal = 115,
    attack = 36,
    defense = 16,
    gold = 100,
    xp = 85)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}