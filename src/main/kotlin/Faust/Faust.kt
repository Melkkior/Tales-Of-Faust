package Faust
import Faust.Swords.Sword
import Faust.Armors.Armor

class Faust {
    public var Status = true
    public var Level = 1
    public var Life = 120 + ((Level - 1) * 40)
    public var Defese = 14 + ((Level - 1) * 3)
    public var Attack = 24 + ((Level - 1) * 6)
    public var XPatual = 0
    public var XPtotal = 100
    public var Sword = Sword()
    public var Armor = Armor()

    fun Atacar(DefM: Int): Int{
        return Attack - DefM
    }

    fun Evoluir(){
        Level++
        XPatual = 0
        XPtotal = 100 * (15 / 10)
    }
}