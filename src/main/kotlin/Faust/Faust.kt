package Faust
import Faust.Swords.Sword
import Faust.Itens.Pocoes

class Faust {
    public var Alive = true
    public var Level = 1
    public var Life = 100
    public var LifeTotal = 100
    public var Defese = 8
    public var Attack = 20
    public var XP = 0
    public var XPtotal = 100
    public var Gold = 0
    public var swordList: MutableList<Sword?> = mutableListOf()
    public var itensList: MutableList<Pocoes?> = mutableListOf()

    fun Atacar(DefM: Int, Fausto: Faust): Int{
        var dano = Attack
        for (i in Fausto.swordList){
            if(i?.equiped == true){
                dano += i.attack
            }
        }
        return dano - DefM
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
        LifeTotal = 100 + ((Level - 1) * 25)
        Life = LifeTotal
        Defese = 14 + ((Level - 1) * 2)
        Attack = 24 + ((Level - 1) * 4)
    }
}