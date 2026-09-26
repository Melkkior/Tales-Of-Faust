package Faust
import Faust.Swords.Sword
import Faust.Armors.Armor

class Faust {
    public var Alive = true
    public var Level = 1
    public var Life = 120
    public var LifeTotal = 120
    public var Defese = 14
    public var Attack = 24
    public var XP = 0
    public var XPtotal = 100
    public var Gold = 0
    public var Sword = Sword()
    public var Armor = Armor()

    fun Atacar(DefM: Int): Int{
        return Attack - DefM
    }

    fun Evoluir(xpM: Int){
        XP += xpM
    }

    fun saquear(ouro: Int){
        Gold += ouro
    }

    fun SubirDeNivel(){
        Level++
        XP = 0
        XPtotal = (100 * 1.5).toInt()
        LifeTotal = 120 + ((Level - 1) * 35)
        Life = LifeTotal
        Defese = 14 + ((Level - 1) * 3)
        Attack = 24 + ((Level - 1) * 6)
    }
}