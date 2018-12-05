import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    val bigHeadSon = BigHeadSon()
    //爷爷奶奶给了100块钱
    bigHeadSon.ysMoney = 100
    //取压岁钱
    println(bigHeadSon.ysMoney)
}
class BigHeadSon {
    var ysMoney: Int by Mother()
}
class Mother {
    var sonMoney = 0
    var selfMoney = 0
    operator fun getValue(bigHeadSon: BigHeadSon, property: KProperty<*>): Int {
        return sonMoney
    }

    operator fun setValue(bigHeadSon: BigHeadSon, property: KProperty<*>, i: Int) {
        sonMoney += 50
        selfMoney += i - 50
    }

}