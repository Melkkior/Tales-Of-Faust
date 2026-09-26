import Faust.Faust
import Monsters.Goblin
fun main() {
    var Fausto = Faust()
    var Monster = Goblin()
    while(Fausto.Alive == true && Monster.Alive == true){
        println("[${Monster.name}] apareceu!")
        println("[${Monster.name}'s life] -> ${Monster.life}/${Monster.lifeTotal}")
    }
}