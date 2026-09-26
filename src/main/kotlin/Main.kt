import Faust.Faust
import Monsters.monster
fun main() {
    var Fausto = Faust()
    var Monster = monster()
    var decisao = 0
    println("[${Monster.name}] apareceu!")
    while(Fausto.Alive == true && Monster.Alive == true){
        println("[${Monster.name}'s life] -> ${Monster.life}/${Monster.lifeTotal}")
        println("[FAUSTO's life] -> ${Fausto.Life}/${Fausto.LifeTotal}")
        println("O que [FAUSTO] fará?")
        println("[1] Atacar;\n[2] Curar;")
        decisao = readLine()!!.toInt()
        when (decisao) {
            1 -> {
                val dano = Fausto.Atacar(Monster.defense)
                Monster.life -= dano
                println("[FAUSTO] atacou [${Monster.name}]!")
                println("[FAUSTO] causou ${dano} de dano ao monstro.")
            }
            2 -> println("Ação indisponivel no momento")
        }
        if(Monster.life > 0){
            println("[${Monster.name}] usou atacar!]")
            val dano = Monster.Atacar(Fausto.Defese)
            Fausto.Life -= dano
            println("[${Monster.name}] causou ${dano} de dano ao heroi.]")
            if (Fausto.Life < 0){
                Fausto.Alive = false
                println("[FAUSTO PERDEU A LUTA...]")
            }
        } else{
            Monster.Alive = false
            println("[FAUSTO] VENCEU A LUTA!!")
            println("XP ganho -> ${Monster.xp}")
            println("Ouro saqueado -> ${Monster.gold}")
            Fausto.Evoluir(Monster.xp)
            Fausto.saquear(Monster.gold)
        }
    }
    println("[Fausto's status]")
    println("[Fausto's Level] -> ${Fausto.Level}")
    println("[Fausto's life] -> ${Fausto.Life}/${Fausto.LifeTotal}")
    println("[Fausto's xp] -> ${Fausto.XP}/${Fausto.XPtotal}")
    println("[Fausto's gold] -> ${Fausto.Gold}")
}