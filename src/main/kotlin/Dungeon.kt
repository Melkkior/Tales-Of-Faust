import Faust.Faust
import Faust.Itens.Poc.PocaoG
import Faust.Itens.Poc.PocaoM
import Faust.Itens.Poc.PocaoP
import Faust.Swords.Sw.Gungnir
import Faust.Swords.Sw.Katana
import Faust.Swords.Sw.`Werther's Gun`


public class Dungeon {
    public var nivelDungeon = 1
    public var proxNivel = 0
    public var NameNivel = true
    public var MenuRep = true
    var katana = Katana()
    var gungnir = Gungnir()
    var werther = `Werther's Gun`()
    var pocaop = PocaoP()
    var pocaom = PocaoM()
    var pocaog = PocaoG()

    fun ProximaSala()
    {
        proxNivel++
        MenuRep = false
    }

    fun ProximoNivelDungeon()
    {
        nivelDungeon++
        proxNivel = 0
        MenuRep = false
        NameNivel = true
    }

    fun loja(Faust: Faust)
    {
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
                        if (Faust.Gold >= 100) {
                            println("[Fausto] comprou [${katana.nome}]!")
                            Faust.swordList.add(katana)
                        } else {
                            println("Dinheiro insuficiente.")
                        }
                    }
                    2 -> {
                        if (Faust.Gold >= 250) {
                            println("[Fausto] comprou [${gungnir.nome}]!")
                            Faust.swordList.add(gungnir)
                        } else {
                            println("Dinheiro insuficiente.")
                        }
                    }
                    3 -> {
                        if (Faust.Gold >= 400) {
                            println("[Fausto] comprou [${werther.nome}]!")
                            Faust.swordList.add(werther)
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
                            if (Faust.Gold >= valorTotal) {
                                println("[Fausto] comprou $resV [${pocaop.nome}]!")
                                if(pocaop.inventory != true){
                                    Faust.itensList.add(pocaop)
                                    pocaop.qnt += resV
                                } else {
                                    pocaop.qnt += resV
                                }
                                Faust.Gold -= valorTotal
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
                            if (Faust.Gold >= valorTotal) {
                                println("[Fausto] comprou $resV [${pocaom.nome}]!")
                                if(pocaop.inventory != true){
                                    Faust.itensList.add(pocaom)
                                    pocaom.qnt += resV
                                } else {
                                    pocaom.qnt += resV
                                }
                                Faust.Gold -= valorTotal
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
                            if (Faust.Gold >= valorTotal) {
                                println("[Fausto] comprou $resV [${pocaog.nome}]!")
                                if(pocaop.inventory != true){
                                    Faust.itensList.add(pocaog)
                                    pocaog.qnt += resV
                                } else {
                                    pocaog.qnt += resV
                                }
                                Faust.Gold -= valorTotal
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

    fun Status(Faust: Faust)
    {
        println("[Fausto's status]")
        println("[Fausto's Level] -> ${Faust.Level}")
        println("[Fausto's life] -> ${Faust.Life}/${Faust.LifeTotal}")
        println("[Fausto's xp] -> ${Faust.XP}/${Faust.XPtotal}")
        println("[Fausto's gold] -> ${Faust.Gold}")
        println("[Fausto's attack ->] ${Faust.Attack}")
        println("[Fausto's defese ->] ${Faust.Defese}")
    }

    fun InventarioArmas(Faust: Faust)
    {
        var n = 1
        if(Faust.swordList.isEmpty()) {
            println("[FAUSTO] não tem nenhuma espada!")
        } else {
            println("[Fausto's swords]")
            for (i in Faust.swordList) {
                if (i?.equiped == true) {
                    println("$n - ${i?.nome} [EQUIPPED]")
                    n++
                } else {
                    println("$n - ${i?.nome}")
                    n++
                }
            }
            println("[Digite 0 para sair]")
            while (true) {
                println("Deseja equipar qual arma?")
                val resV = readLine()?.toIntOrNull()

                if (resV == null || resV < 0) {
                    println("Insira um valor válido.")
                    continue
                }
                if(resV == 0){
                    break
                }

                var t = resV - 1
                Faust.swordList[t]?.equipLevel?.let {
                    if (it > Faust.Level) {
                        println("[FAUSTO] não tem nivel o suficiente para equipar esta espada!")
                    } else {
                        for (i in Faust.swordList) {
                            i?.equiped = false
                        }
                        Faust.swordList[t]?.equiped = true;
                        println("[FAUSTO] equipou [${Faust.swordList[t]?.nome}]")
                        break
                    }
                }
            }
        }
    }

    fun InventarioPocoes(Faust: Faust)
    {
        var n = 1
        if (Faust.itensList.isEmpty()){
            println("[FAUSTO] não tem nenhuma poção!")
        } else {
            println("[Fausto's poções]")

            for (i in Faust.itensList) {
                println("$n - ${i?.nome} [${i?.qnt}]")
                n++
            }
            println("[Digite 0 para sair]")
            while(true) {
                println("[Usar qual item de cura?]")
                val resV = readLine()?.toIntOrNull()

                if (resV == null || resV <= 0) {
                    println("Insira um valor válido.")
                    continue
                }

                var t = resV - 1
                Faust.itensList[t]?.qnt--
                Faust.Life += Faust.itensList[t]?.heal ?: 0
                if (Faust.Life > Faust.LifeTotal) {
                    Faust.Life = Faust.LifeTotal
                }
                if (Faust.itensList[t]?.qnt == 0) {
                    Faust.itensList.removeAt(t)
                }
                println("[Fausto] se curou!")
                break
            }
        }
    }

}