import kotlin.system.exitProcess
import Faust.Faust
import kotlin.random.Random
import Monsters.goblin
import Monsters.FadaGelo
import Monsters.Corvo
import Monsters.Slime
import Monsters.Prinny
import Monsters.`Nivel 1`.Monster
import Monsters.`Nivel 2`.Bruxa
import Monsters.`Nivel 2`.Esqueleto
import Monsters.`Nivel 2`.Fantasma
import Monsters.`Nivel 2`.Lobo
import Monsters.`Nivel 2`.Sacerdotisa
import Monsters.`Nivel 3`.Bibliotecaria
import Monsters.`Nivel 3`.China
import Monsters.`Nivel 3`.Principe
import Monsters.`Nivel 3`.Princesa
import Monsters.`Nivel 3`.Tubarao
import Monsters.`Nivel 4`.Cultista
import Monsters.`Nivel 4`.Empregada
import Monsters.`Nivel 4`.Golem
import Monsters.`Nivel 4`.Oni
import Monsters.`Nivel 4`.Valkyria
import Monsters.`Nivel 5`.Hydra
import Monsters.`Nivel 5`.Marte
import Monsters.`Nivel 5`.Rei
import Monsters.`Nivel 5`.Tepes
import Monsters.`Nivel 5`.Vampira

fun main() {
    var Fausto = Faust()
    var nivelDungeon = 1
    var proxNivel = 0
    var kk = true

    while (true){
    if(kk == true){
        when (nivelDungeon){
            1 -> {
                println("[DUNGEON NV01] OS SOFRIMENTOS DO JOVEM WERTHER")
                kk = false
            }
            2 -> {
                println("[DUNGEON NV02] AFINIDADES ELETIVAS")
                kk = false
            }
            3 -> {
                println("[DUNGEON NV03] TRILOGIA DA PAIXÃO")
                kk = false
            }
            4 -> {
                println("[DUNGEON NV04] OS ANOS DE APRENDIZADO DE WILHELM MEISTER")
                kk = false
            }
            5 -> {
                println("[DUNGEON NV05] FAUSTO")
                kk = false
            }
        }
    }
        var num = Random.nextInt(1,5)
        var Monster: Monster? = null
        when(nivelDungeon){
            1->{
                when (num)
                {
                    1 -> {Monster = FadaGelo()}
                    2 -> {Monster = Corvo()}
                    3 -> {Monster = goblin()}
                    4 -> {Monster = Slime()}
                    5 -> {Monster = Prinny()}
                }
            }
            2->{
                when (num)
                {
                    1 -> {Monster = Lobo()}
                    2 -> {Monster = Fantasma()}
                    3 -> {Monster = Sacerdotisa()}
                    4 -> {Monster = Bruxa()}
                    5 -> {Monster = Esqueleto()}
                }
            }
            3->{
                when (num)
                {
                    1 -> {Monster = China()}
                    2 -> {Monster = Bibliotecaria()}
                    3 -> {Monster = Princesa()}
                    4 -> {Monster = Principe()}
                    5 -> {Monster = Tubarao()}
                }
            }
            4->{
                when (num)
                {
                    1 -> {Monster = Valkyria()}
                    2 -> {Monster = Golem()}
                    3 -> {Monster = Cultista()}
                    4 -> {Monster = Oni()}
                    5 -> {Monster = Empregada()}
                }
            }
            5->{
                when (num)
                {
                    1 -> {Monster = Tepes()}
                    2 -> {Monster = Vampira()}
                    3 -> {Monster = Marte()}
                    4 -> {Monster = Rei()}
                    5 -> {Monster = Hydra()}
                }
            }
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
                        kk = true
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