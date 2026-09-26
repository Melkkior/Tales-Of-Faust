import kotlin.system.exitProcess
import Faust.Faust
import kotlin.random.Random
import Monsters.goblin
import Monsters.FadaGelo
import Monsters.Corvo
import Monsters.Slime
import Monsters.Prinny
import Monsters.`Nivel 1`.Monster

fun main() {
    var Fausto = Faust()
    var nivelDungeon = 1
    var proxNivel = 0

    while (true){

        var num = Random.nextInt(1,5)
        var Monster: Monster? = null
        when (num)
        {
            1 -> {Monster = FadaGelo()}
            2 -> {Monster = Corvo()}
            3 -> {Monster = goblin()}
            4 -> {Monster = Slime()}
            5 -> {Monster = Prinny()}
        }

        val monstro = Monster ?: throw IllegalStateException("Monstro não foi inicializado")
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
                2 -> {
                    if(Fausto.Life >= 100){
                        println("[FAUSTO] já esta com a vida cheia!")
                    } else{
                        println("[FAUSTO] se curou!!")
                        Fausto.Life += 45
                        if(Fausto.Life >= 100){
                            Fausto.Life = Fausto.Life - (Fausto.Life - Fausto.LifeTotal).toInt()
                        }
                    }
                }
            }
            if(Monster.life > 0){
                println("[${Monster.name}] usou atacar!")
                val dano = Monster.Atacar(Fausto.Defese)
                Fausto.Life -= dano
                println("[${Monster.name}] causou ${dano} de dano ao heroi.")

                if (Fausto.Life < 0){
                    Fausto.Alive = false
                    println("[FAUSTO PERDEU A LUTA...]")
                    println("{FIM DE JOGO}")
                    exitProcess(0)
                }
            } else{
                Monster.Alive = false
                println("[FAUSTO] VENCEU A LUTA!!")
                println("XP ganho -> ${Monster.xp}")
                println("Ouro saqueado -> ${Monster.gold}")
                Fausto.Evoluir(Monster.xp)
                Fausto.saquear(Monster.gold)

                if(Fausto.XP >= Fausto.XPtotal){
                    println("[FAUSTO] SUBIU DE NIVEL!!!")
                    Fausto.SubirDeNivel()
                }
            }
        }

        var rep = true
        while (rep == true){
            println("Proxima decisão de [FAUSTO]?")
            var decisao01: Int
            if(proxNivel >= 5){
                println("[1] prosseguir para a proxima sala.")
                println("[2] Ir ao proximo nivel da dungeon")
                println("[3] Ir a loja.")
                println("[4] Conferir status")
                decisao01 = readLine()!!.toInt()
                when (decisao01) {
                    1 -> {
                        proxNivel++
                        rep = false
                    }
                    2 -> {
                        nivelDungeon++
                        proxNivel = 0
                        rep = false
                    }
                    3 -> println("Alternativa indisponivel no momento")
                    4 -> {
                        println("[Fausto's status]")
                        println("[Fausto's Level] -> ${Fausto.Level}")
                        println("[Fausto's life] -> ${Fausto.Life}/${Fausto.LifeTotal}")
                        println("[Fausto's xp] -> ${Fausto.XP}/${Fausto.XPtotal}")
                        println("[Fausto's gold] -> ${Fausto.Gold}")
                    }
                }
            } else {
                println("[1] prosseguir para a proxima sala")
                println("[2] Ir a loja.")
                println("[3] Conferir status")
                decisao01 = readLine()!!.toInt()
                when (decisao01) {
                    1 -> {
                        proxNivel++
                        rep = false
                    }
                    2 -> println("Alternativa indisponivel no momento")
                    3 -> {
                        println("[Fausto's status]")
                        println("[Fausto's Level] -> ${Fausto.Level}")
                        println("[Fausto's life] -> ${Fausto.Life}/${Fausto.LifeTotal}")
                        println("[Fausto's xp] -> ${Fausto.XP}/${Fausto.XPtotal}")
                        println("[Fausto's gold] -> ${Fausto.Gold}")
                    }
                }
            }
        }
    }



}