package Monsters.`Nivel 2`
import Monsters.`Nivel 1`.Monster

class Esqueleto : Monster
    (name = "Esqueleto",
    Alive = true,
    life = 50,
    lifeTotal = 50,
    attack = 17,
    defense = 13,
    gold = 20,
    xp = 25)
{
    override fun Atacar(DefF: Int): Int{
        return attack - DefF
    }
}