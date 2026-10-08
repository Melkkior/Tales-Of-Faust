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
import Faust.Itens.Pocoes
import Faust.Itens.Poc.Bratwurst
import Faust.Itens.Poc.`Fruta Vermelha`
import Faust.Itens.Poc.Vinho
import Faust.Itens.Poc.PocaoP
import Faust.Itens.Poc.PocaoG
import Faust.Itens.Poc.PocaoM
import Faust.Swords.Sword
import Faust.Swords.Sw.Gladius
import Faust.Swords.Sw.`Espada de Madeira`
import Faust.Swords.Sw.Gungnir
import Faust.Swords.Sw.Katana
import Faust.Swords.Sw.`Werther's Gun`
import Faust.Swords.Sw.zweihander
import Faust.Swords.Sw.`Siegfried's sword`
import kotlin.contracts.SimpleEffect


fun main() {
    var Fausto = Faust()
    var nivelDungeon = 1
    var proxNivel = 0
    var kk = true
    var gladius = Gladius()
    var madeira = `Espada de Madeira`()
    var katana = Katana()
    var gungnir = Gungnir()
    var werther = `Werther's Gun`()
    var zweihander = zweihander()
    var siegfried = `Siegfried's sword`()
    var fruta = `Fruta Vermelha`()
    var bratwurst = Bratwurst()
    var vinho = Vinho()
    var pocaop = PocaoP()
    var pocaom = PocaoM()
    var pocaog = PocaoG()
    while (true) {
        if (kk == true) {
            when (nivelDungeon) {
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
        var tes = Random.nextInt(1, 10)
        if (tes <= 2) {
            var num = Random.nextInt(1, 5)
            var Monster: Monster? = null
            when (nivelDungeon) {
                1 -> {
                    when (num) {
                        1 -> {
                            Monster = FadaGelo()
                        }

                        2 -> {
                            Monster = Corvo()
                        }

                        3 -> {
                            Monster = goblin()
                        }

                        4 -> {
                            Monster = Slime()
                        }

                        5 -> {
                            Monster = Prinny()
                        }
                    }
                }

                2 -> {
                    when (num) {
                        1 -> {
                            Monster = Lobo()
                        }

                        2 -> {
                            Monster = Fantasma()
                        }

                        3 -> {
                            Monster = Sacerdotisa()
                        }

                        4 -> {
                            Monster = Bruxa()
                        }

                        5 -> {
                            Monster = Esqueleto()
                        }
                    }
                }

                3 -> {
                    when (num) {
                        1 -> {
                            Monster = China()
                        }

                        2 -> {
                            Monster = Bibliotecaria()
                        }

                        3 -> {
                            Monster = Princesa()
                        }

                        4 -> {
                            Monster = Principe()
                        }

                        5 -> {
                            Monster = Tubarao()
                        }
                    }
                }

                4 -> {
                    when (num) {
                        1 -> {
                            Monster = Valkyria()
                        }

                        2 -> {
                            Monster = Golem()
                        }

                        3 -> {
                            Monster = Cultista()
                        }

                        4 -> {
                            Monster = Oni()
                        }

                        5 -> {
                            Monster = Empregada()
                        }
                    }
                }

                5 -> {
                    when (num) {
                        1 -> {
                            Monster = Tepes()
                        }

                        2 -> {
                            Monster = Vampira()
                        }

                        3 -> {
                            Monster = Marte()
                        }

                        4 -> {
                            Monster = Rei()
                        }

                        5 -> {
                            Monster = Hydra()
                        }
                    }
                }
            }

            val monstro = Monster ?: throw IllegalStateException("Monster não foi inicializado")
            var decisao = 0

            println("[${Monster.name}] apareceu!")
            while (Fausto.Alive == true && Monster.Alive == true) {
                println("[${Monster.name}'s life] -> ${Monster.life}/${Monster.lifeTotal}")
                println("[FAUSTO's life] -> ${Fausto.Life}/${Fausto.LifeTotal}")
                println("O que [FAUSTO] fará?")
                println("[1] Atacar;\n[2] Curar;")
                decisao = readLine()!!.toInt()
                var repA = true
                while (repA) {
                    when (decisao) {
                        1 -> {
                            val dano = Fausto.Atacar(Monster.defense)
                            Monster.life -= dano
                            println("[FAUSTO] atacou [${Monster.name}]!")
                            println("[FAUSTO] causou ${dano} de dano ao monstro.")
                            repA = false
                        }

                        2 -> {
                            if (Fausto.Life >= 100) {
                                println("[FAUSTO] já esta com a vida cheia!")
                            } else {
                                println("[FAUSTO] se curou!!")
                                Fausto.Life += 45
                                if (Fausto.Life >= 100) {
                                    Fausto.Life = Fausto.Life - (Fausto.Life - Fausto.LifeTotal).toInt()
                                }
                            }
                            repA = false
                        }
                        else -> println("Ação invalida.")
                    }
                }
                if (Monster.life > 0) {
                    println("[${Monster.name}] usou atacar!")
                    val dano = Monster.Atacar(Fausto.Defese)
                    Fausto.Life -= dano
                    println("[${Monster.name}] causou ${dano} de dano ao heroi.")

                    if (Fausto.Life < 0) {
                        Fausto.Alive = false
                        println("[FAUSTO PERDEU A LUTA...]")
                        println("{FIM DE JOGO}")
                        exitProcess(0)
                    }
                } else {
                    Monster.Alive = false
                    println("[FAUSTO] VENCEU A LUTA!!")
                    println("XP ganho -> ${Monster.xp}")
                    println("Ouro saqueado -> ${Monster.gold}")
                    Fausto.Evoluir(Monster.xp)
                    Fausto.saquear(Monster.gold)

                    if (Fausto.XP >= Fausto.XPtotal) {
                        println("[FAUSTO] SUBIU DE NIVEL!!!")
                        Fausto.SubirDeNivel()
                    }
                }
            }
        } else {
            println("[FAUSTO ENCONTROU UM TESOURO]")
            var ouroR = Random.nextInt(30, 300)
            println("[FAUSTO] encontrou ${ouroR} de ouro.")
            Fausto.Gold += ouroR
            var sran = Random.nextInt(1, 100)
            when (sran) {
                in 1..40 -> {
                    if (madeira.inventory == false) {
                        madeira.inventory = true
                        Fausto.swordList.add(madeira)
                        println("[FAUSTO ACHOU ${madeira.nome}]")
                    }
                }

                in 41..70 -> {
                    if (gladius.inventory == false) {
                        gladius.inventory = true
                        Fausto.swordList.add(gladius)
                        println("[FAUSTO ACHOU ${gladius.nome}]")
                    }
                }

                in 71..90 -> {
                    if (siegfried.inventory == false) {
                        siegfried.inventory = true
                        Fausto.swordList.add(siegfried)
                        println("[FAUSTO ACHOU ${siegfried.nome}]")
                    }
                }

                in 91..100 -> {
                    if (zweihander.inventory == false) {
                        zweihander.inventory = true
                        Fausto.swordList.add(zweihander)
                        println("[FAUSTO ACHOU ${zweihander.nome}]")
                    }
                }

            }
            var pran = Random.nextInt(1, 100)
            when (pran) {
                in 1..50 -> {
                    var qntran = Random.nextInt(1, 10)
                    if (fruta.inventory == false) {
                        fruta.inventory = true
                        fruta.qnt += qntran
                        Fausto.itensList.add(fruta)
                        println("[FAUSTO ACHOU $qntran ${fruta.nome}s]")
                    }
                }

                in 51..70 -> {
                    var qntran = Random.nextInt(1, 10)
                    if (bratwurst.inventory == false) {
                        bratwurst.inventory = true
                        bratwurst.qnt += qntran
                        Fausto.itensList.add(bratwurst)
                        println("[FAUSTO ACHOU $qntran ${bratwurst.nome}s]")
                    }
                }

                in 71..100 -> {
                    var qntran = Random.nextInt(1, 10)
                    if (vinho.inventory == false) {
                        vinho.inventory = true
                        vinho.qnt += qntran
                        Fausto.itensList.add(vinho)
                        println("[FAUSTO ACHOU $qntran ${vinho.nome}s]")
                    }
                }
            }
        }
        println("O caminho para o proximo nivel esta livre!!!")
        println("[~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~]")
        var rep = true
        while (rep == true) {
            println("Proxima decisão de [FAUSTO]?")
            var decisao01: Int
            if (proxNivel >= 5) {
                println("[1] prosseguir para a proxima sala.")
                println("[2] Ir ao proximo nivel da dungeon")
                println("[3] Ir a loja.")
                println("[4] Conferir status")
                println("[5] Inventario de armas")
                println("[6] Inventario de poções")
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

                    3 -> {
                        println("[Bem vindo à loja do vendedor Schiller!]")
                        println("1 - conferir lista de armas.\n2 - conferir lista de poções.\n3 - sair da loja.")
                        var res = readLine()?.toInt()
                        when(res) {
                            1 -> {
                                println("[Lista de espadas]")
                                println("1 - ${katana.nome} {$100}")
                                println("2 - ${gungnir.nome} {$250}")
                                println("3 - ${werther.nome} {$400}")
                                println("O que deseja comprar?")
                                var resS = readLine()?.toInt()
                                when (resS){
                                    1 -> {
                                        if (Fausto.Gold >= 100) {
                                            println("[FAUSTO] comprou [${katana.nome}]!")
                                            Fausto.swordList.add(katana)
                                        } else {
                                            println("Dinheiro insuficiente.")
                                        }
                                    }
                                    2 -> {
                                        if (Fausto.Gold >= 250) {
                                            println("[FAUSTO] comprou [${gungnir.nome}]!")
                                            Fausto.swordList.add(gungnir)
                                        } else {
                                            println("Dinheiro insuficiente.")
                                        }
                                    }
                                    3 -> {
                                        if (Fausto.Gold >= 400) {
                                            println("[FAUSTO] comprou [${werther.nome}]!")
                                            Fausto.swordList.add(werther)
                                        } else {
                                            println("Dinheiro insuficiente.")
                                        }
                                    }
                                    else -> println("Saindo da loja")
                                }
                            }
                            2 -> {
                                println("[Lista de Poções]")
                                println("1 - ${pocaop.nome} {$30}")
                                println("2 - ${pocaom.nome} {$60}")
                                println("3 - ${pocaog.nome} {$90}")
                                println("[O que vai comprar?]")
                                var resP = readLine()?.toInt()
                                when (resP){
                                    1 -> {
                                        println("[Quantas deseja comprar?]")
                                        var pop = true
                                        while (pop) {
                                            val resV = readLine()?.toIntOrNull()
                                            if (resV == null || resV <= 0) {
                                                println("Insira uma quantidade válida.")
                                                continue
                                            }
                                            val valorTotal = 30 * resV
                                            if (Fausto.Gold >= valorTotal) {
                                                println("[FAUSTO] comprou $resV [${pocaop.nome}]!")
                                                if(pocaop.inventory != true){
                                                    Fausto.itensList.add(pocaop)
                                                    pocaop.qnt += resV
                                                } else {
                                                    pocaop.qnt += resV
                                                }
                                                Fausto.Gold -= valorTotal
                                                pop = false
                                            } else {
                                                println("Dinheiro insuficiente.")
                                                pop = false
                                            }
                                        }
                                    }
                                    2 -> {
                                        println("[Quantas deseja comprar?]")
                                        var pop = true
                                        while (pop) {
                                            val resV = readLine()?.toIntOrNull()
                                            if (resV == null || resV <= 0) {
                                                println("Insira uma quantidade válida.")
                                                continue
                                            }
                                            val valorTotal = 60 * resV
                                            if (Fausto.Gold >= valorTotal) {
                                                println("[FAUSTO] comprou $resV [${pocaom.nome}]!")
                                                if(pocaop.inventory != true){
                                                    Fausto.itensList.add(pocaom)
                                                    pocaom.qnt += resV
                                                } else {
                                                    pocaom.qnt += resV
                                                }
                                                Fausto.Gold -= valorTotal
                                                pop = false
                                            } else {
                                                println("Dinheiro insuficiente.")
                                                pop = false
                                            }
                                        }
                                    }
                                    3 -> {
                                        println("[Quantas deseja comprar?]")
                                        var pop = true
                                        while (pop) {
                                            val resV = readLine()?.toIntOrNull()
                                            if (resV == null || resV <= 0) {
                                                println("Insira uma quantidade válida.")
                                                continue
                                            }
                                            val valorTotal = 90 * resV
                                            if (Fausto.Gold >= valorTotal) {
                                                println("[FAUSTO] comprou $resV [${pocaog.nome}]!")
                                                if(pocaop.inventory != true){
                                                    Fausto.itensList.add(pocaog)
                                                    pocaog.qnt += resV
                                                } else {
                                                    pocaog.qnt += resV
                                                }
                                                Fausto.Gold -= valorTotal
                                                pop = false
                                            } else {
                                                println("Dinheiro insuficiente.")
                                                pop = false
                                            }
                                        }
                                    }
                                    else -> println("Saindo da loja")
                                }
                            }
                            else -> println("Saindo da loja.")
                        }
                    }
                    4 -> {
                        println("[Fausto's status]")
                        println("[Fausto's Level] -> ${Fausto.Level}")
                        println("[Fausto's life] -> ${Fausto.Life}/${Fausto.LifeTotal}")
                        println("[Fausto's xp] -> ${Fausto.XP}/${Fausto.XPtotal}")
                        println("[Fausto's gold] -> ${Fausto.Gold}")
                    }

                    5 -> {println("[Fausto's swords]")
                        for (i in Fausto.swordList) {

                            println("-${i?.nome}")
                        }
                    }

                    6 -> {
                        println("[Fausto's poções]")
                        for (i in Fausto.itensList) {
                            println("-${i?.nome} [${i?.qnt}]")
                        }
                    }

                    else -> {
                        println("Comando invalido")
                    }
                }
            } else {
                println("[1] prosseguir para a proxima sala")
                println("[2] Ir a loja.")
                println("[3] Conferir status")
                println("[4] Inventario de armas")
                println("[5] Inventario de poções")
                decisao01 = readLine()!!.toInt()
                when (decisao01) {
                    1 -> {
                        proxNivel++
                        rep = false
                    }

                    2 -> {
                        println("[Bem vindo à loja do vendedor Schiller!]")
                        println("1 - conferir lista de armas.\n2 - conferir lista de poções.\n3 - sair da loja.")
                        var res = readLine()?.toInt()
                        when(res) {
                            1 -> {
                                println("[Lista de espadas]")
                                println("1 - ${katana.nome} {$100}")
                                println("2 - ${gungnir.nome} {$250}")
                                println("3 - ${werther.nome} {$400}")
                                println("O que deseja comprar?")
                                var resS = readLine()?.toInt()
                                when (resS){
                                    1 -> {
                                        if (Fausto.Gold >= 100) {
                                            println("[FAUSTO] comprou [${katana.nome}]!")
                                            Fausto.swordList.add(katana)
                                            Fausto.Gold -= 100
                                        } else {
                                            println("Dinheiro insuficiente.")
                                        }
                                    }
                                    2 -> {
                                        if (Fausto.Gold >= 250) {
                                            println("[FAUSTO] comprou [${gungnir.nome}]!")
                                            Fausto.swordList.add(gungnir)
                                            Fausto.Gold -= 250
                                        } else {
                                            println("Dinheiro insuficiente.")
                                        }
                                    }
                                    3 -> {
                                        if (Fausto.Gold >= 400) {
                                            println("[FAUSTO] comprou [${werther.nome}]!")
                                            Fausto.swordList.add(werther)
                                            Fausto.Gold -= 400
                                        } else {
                                            println("Dinheiro insuficiente.")
                                        }
                                    }
                                    else -> println("Saindo da loja")
                                }
                            }
                            2 -> {
                                println("[Lista de Poções]")
                                println("1 - ${pocaop.nome} {$30}")
                                println("2 - ${pocaom.nome} {$60}")
                                println("3 - ${pocaog.nome} {$90}")
                                println("[O que vai comprar?]")
                                var resP = readLine()?.toInt()
                                when (resP){
                                    1 -> {
                                        println("[Quantas deseja comprar?]")
                                        var pop = true
                                        while (pop) {
                                            val resV = readLine()?.toIntOrNull()
                                            if (resV == null || resV <= 0) {
                                                println("Insira uma quantidade válida.")
                                                continue
                                            }
                                            val valorTotal = 30 * resV
                                            if (Fausto.Gold >= valorTotal) {
                                                println("[FAUSTO] comprou $resV [${pocaop.nome}]!")
                                                if(pocaop.inventory != true){
                                                    Fausto.itensList.add(pocaop)
                                                    pocaop.qnt += resV
                                                } else {
                                                    pocaop.qnt += resV
                                                }

                                                Fausto.Gold -= valorTotal
                                                pop = false
                                            } else {
                                                println("Dinheiro insuficiente.")
                                                pop = false
                                            }
                                        }
                                    }
                                    2 -> {
                                        println("[Quantas deseja comprar?]")
                                        var pop = true
                                        while (pop) {
                                            val resV = readLine()?.toIntOrNull()
                                            if (resV == null || resV <= 0) {
                                                println("Insira uma quantidade válida.")
                                                continue
                                            }
                                            val valorTotal = 60 * resV
                                            if (Fausto.Gold >= valorTotal) {
                                                println("[FAUSTO] comprou $resV [${pocaom.nome}]!")
                                                if(pocaop.inventory != true){
                                                    Fausto.itensList.add(pocaom)
                                                    pocaom.qnt += resV
                                                } else {
                                                    pocaom.qnt += resV
                                                }
                                                Fausto.Gold -= valorTotal
                                                pop = false
                                            } else {
                                                println("Dinheiro insuficiente.")
                                                pop = false
                                            }
                                        }
                                    }
                                    3 -> {
                                        println("[Quantas deseja comprar?]")
                                        var pop = true
                                        while (pop) {
                                            val resV = readLine()?.toIntOrNull()
                                            if (resV == null || resV <= 0) {
                                                println("Insira uma quantidade válida.")
                                                continue
                                            }
                                            val valorTotal = 90 * resV
                                            if (Fausto.Gold >= valorTotal) {
                                                println("[FAUSTO] comprou $resV [${pocaog.nome}]!")
                                                if(pocaop.inventory != true){
                                                    Fausto.itensList.add(pocaog)
                                                    pocaog.qnt += resV
                                                } else {
                                                    pocaog.qnt += resV
                                                }
                                                Fausto.Gold -= valorTotal
                                                pop = false
                                            } else {
                                                println("Dinheiro insuficiente.")
                                                pop = false
                                            }
                                        }
                                    }
                                    else -> println("Saindo da loja")
                                }
                            }
                            else -> println("Saindo da loja.")
                        }
                    }
                    3 -> {
                        println("[Fausto's status]")
                        println("[Fausto's Level] -> ${Fausto.Level}")
                        println("[Fausto's life] -> ${Fausto.Life}/${Fausto.LifeTotal}")
                        println("[Fausto's xp] -> ${Fausto.XP}/${Fausto.XPtotal}")
                        println("[Fausto's gold] -> ${Fausto.Gold}")
                        println("[Fausto's swords]")
                    }

                    4 -> {
                        var n = 1
                        println("[Fausto's swords]")
                        for (i in Fausto.swordList) {
                            if(i?.equiped == true){
                                println("$n - ${i?.nome} [EQUIPPED]")
                                n++
                            } else {
                                println("$n - ${i?.nome}")
                                n++
                            }
                        }
                    }
                    5 -> {
                        var n = 1
                        println("[Fausto's poções]")
                        for (i in Fausto.itensList) {
                            println("$n - ${i?.nome} [${i?.qnt}]")
                            n++
                        }
                    }

                    else -> {
                        println("Comando invalido")
                    }
                }
            }
        }
    }


}