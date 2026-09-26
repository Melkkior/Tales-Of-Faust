package Monsters

class Goblin {
    public var name = "Goblin"
    public var Alive = true
    public var life = 45
    public var lifeTotal = 45
    public var attack = 16
    public var defense = 11
    public var gold = 25
    public var xp = 22

    fun Atacar(DefF: Int): Int{
        return attack - DefF
    }

}