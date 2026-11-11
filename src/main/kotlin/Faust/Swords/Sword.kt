package Faust.Swords

abstract class Sword (
    val nome: String,
    val attack: Int,
    var inventory: Boolean,
    var equiped: Boolean,
    val equipLevel: Int
)
{

}