import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main(args: Array<String>) {

}

private fun m21() {
    val list = ArrayList<Thing>()
    setFruitList(list)
    val list2 = ArrayList<Apple>()
    //下面报错
     setFruitList(list2)
}

fun setFruitList(list:ArrayList<*>){
    println(list.size)
}

private fun m20() {
    val box1 = Box<String>("")
    val box2 = Box<Int>(10)

    //class类型
    val clz1 = box1.javaClass.name
    val clz2 = box2.javaClass.name

    println(clz1)
    println(clz2)
    println(String::class.java)

    parseType(10)
    parseType("frank")
}

inline fun <reified T>parseType(thing:T){
    //获取传递的thing的class类型
    val name = T::class.java.name
    println(name)
}

private fun m19() {
    val apple = Apple()
    val orange = Orange()
    val thing = Thing()
    var fruit = Fruit()
    val fruitBox = FruitBox(apple)
    val fruitBox2 = FruitBox(fruit)
    //下面会报错 泛型限定为Fruit子类
    //val fruitBox = FruitBox(thing)
}

//箱子
open class Box<T>(var thing:T)//物品类型不确定  定义泛型和使用泛型
//水果箱子
class FruitBox<T:Fruit>(thing:T):Box<T>(thing)//只能水果
open class Thing
//水果
open class Fruit: Thing()
//苹果
class Apple:Fruit()
//橘子
class Orange:Fruit()

private fun m18() {
//    parseType(10)
//    parseType("张三")
//    parseType(Apple())
}

//方法 thing  判断类型
//fun <T> parseType(thing: T) {//前面定义泛型  后面使用泛型
//    when (thing) {
//        is Int -> println("是Int类型")
//        is String -> println("是String类型")
//        else -> println("不知道具体类型")
//    }
//}
////箱子
//open class Box<T>(var thing:T)//物品类型不确定  定义泛型和使用泛型
////水果箱子
//class FruitBox(thing:Fruit):Box<Fruit>(thing)
////不知道具体放什么东西
//class SonBox<T>(thing:T):Box<T>(thing)//第一个是申明  后面两个都是使用
////水果
//abstract class Fruit
////苹果
//class Apple:Fruit()
////橘子
//class Orange:Fruit()

class OutClass {
    var name = "张三"

    inner class InnnerClass {
        var name= "李四"
        fun sayHello() {
            println("你好${this@OutClass.name}")
        }
    }
}

//小明
class XiaoMing : ZhHuman(), RideBike, DriveCar {
    override var license: String = "123"
    override fun drive() {
        println("小明学会了开车")
    }

    override fun ride() {
        println("小明学会了骑自行车")
    }
}

//能力用接口表示
interface RideBike {
    //骑自行车行为
    fun ride()
}

//开车能力
interface DriveCar {
    //驾照号码
//    var license:String=""  //kolin接口里面字段不能实现
    var license: String

    //开车行为
    fun drive()
}

//人类 抽象类不用open关键字
abstract class Human {
    //肤色
    abstract var color: String
    //语言
    abstract var language: String

    //吃饭
    abstract fun eat()
}

//中国人
open class ZhHuman : Human() {
    override var color: String = "黄色"
    override var language: String = "中文"

    override fun eat() {
        println("用筷子吃饭")
    }
}

//美国人
class UsHuman : Human() {
    override var color: String = "白色"
    override var language: String = "英文"

    override fun eat() {
        println("用刀叉吃饭")
    }
}

//非洲人
class AfHuman : Human() {
    override var color: String = "黑色"
    override var language: String = "葡萄牙语"

    override fun eat() {
        println("用受抓恩希玛")
    }
}

//kotlin的类都是final的  不能被继承
open class Father {
    open var name = "张三"
    open var age = 20
    //动态行为
    open fun hobby() {
        println("父亲喜欢抽烟")
    }
}

//子承父业
class Son : Father() {
    override var name: String = "张四"
    override var age: Int = 10
    override fun hobby() {
//        super.horbe()
        println("孩子喜欢看书")
    }
}

class Person(var name: String, var age: Int) {
    var phone = ""

    //次构函数必须调用主构函数
    constructor(name: String, age: Int, phone: String) : this(name, age) {
        println("执行了次构函数")
        this.phone = phone
    }

    //先执行初始化,然后再执行次构造函数
    init {
        println("执行了初始化")
    }
}

private fun m15() {
    var a = 10
    var b = 20
    var sum = a.plus(b)
    println(sum)
    println(a + b)
    val g1 = Girl()
    val g2 = Girl()
    var i = g1 + g2
    var i1 = g1.plus(g2)
    println(i)
    println(i1)
}

class Girl {
    var name: String = "aa"
    var age: Int = 20
    operator fun plus(girl: Girl): Int {
        return this.age + girl.age
    }
}

private fun m14() {
    val result = sum3(100000)
    println(result)
}

//尾递归
tailrec fun sum3(n: Int, result: Int = 0): Int {
    if (n == 1) {
        return result + 1
    } else {
        return sum3(n - 1, result + n)
    }
}

private fun m13() {
    //求1到n的数据和  1到10
    val result1 = sum1(10)
    println(result1)
    val result2 = sum2(10)
    println(result2)
}

//求1到n的和  1到10  1到9的和+10   1到n的和  1到n-1的和 + n
fun sum2(n: Int): Int {
    if (n == 1) {
        return 1
    } else {
        return n + sum2(n - 1)
    }
}

/**
 * 求1到n的和  通过迭代的方式求和
 */
fun sum1(n: Int): Int {//kotlin里面参数是固定  不能修改
    var result = 0
    var copyN = n
    while (copyN > 0) {
        result += copyN
        copyN--
    }
    return result
}

private fun m12() {
    //java异常种类:编译时异常  运行时异常
    var a = 10
    var b = 0
    //异常处理
    try {
        a / b
    } catch (e: ArithmeticException) {
        println("捕获到异常")
    } finally {
        println("最终要执行的代码")
    }
    /*---------------------------- koltin编译时异常 ----------------------------*/
    //kotlin不检查编译时异常
    //kotlin认为大部分的编译时异常都是没有必要的
    val file = File("a.txt")
    val bfr = BufferedReader(FileReader(file))
}

private fun m11() {
    var a = 10
    var b = 20
    var c = 30
    var result = sum(a, b, c, 10, 20, 30, 40, 50)
    println(result)
    result = sum(a, b, c)
    println(result)
    result = sum(1, 2, 3)
    println(result)
}

/**
 * 只要是Int数据类型  无论你传递多少个我都能求他们的和  可变参数
 */
fun sum(vararg a: Int): Int {//数组
    //a是什么类型?
    //智能类型推断
//    val newa = a
    var result = 0//和
    a.forEach {
        result += it
    }
    return result
}

private fun m10() {
    sendRequest("http://www.baidu.com", "GET")
    sendRequest("http://www.baidu.com", "POST")
    sendRequest("http://www.baidu.com")
    sendRequest(method = "GET", path = "http://www.baidu.com")//具名参数 参数位置可以变化
}

fun sendRequest(path: String, method: String = "GET") {
    println("请求路径=${path},method=${method}")
}

private fun m09() {
    var a = 10
    var b = 20
    /*---------------------------- 函数引用:: ----------------------------*/
    //对象变量
    //函数变量
    val padd = ::add//::获取add函数的引用
    //类似C语言函数指针
    //通过padd调用函数
    println(padd(a, b))
    println(padd?.invoke(a, b))//可以处理函数变量为空的情况下调用
    /*---------------------------- 函数变量 ----------------------------*/
    val padd1: (Int, Int) -> Int = { a, b -> a + b }//匿名函数
    val padd2: (Int, Int) -> Int = { a, b -> a + b }//匿名函数
    println(padd1(a, b))
}

fun add(a: Int, b: Int) = a + b

private fun m08() {
    val array = arrayOf("张三", "李四", "张四", "王五", "张三", "赵六")
    //查找第一个”张三”角标
    //返回第一对应的元素角标  如果没有找到返回-1
    val index1 = array.indexOf("张三")
    println(index1)
    //查找最后一个”张三”角标
    //找不到 返回-1
    val index2 = array.lastIndexOf("张三")
    println(index2)

    /*---------------------------- 高阶函数实现 ----------------------------*/
    //查找第一个姓”张”的人的角标
//    val index3 = array.indexOfFirst {
//        it.startsWith("张")
//    }
//    println(index3)
    //查找最后一个姓”张”的人的角标
    val index4 = array.indexOfLast { it.startsWith("张") }
    println(index4)

    val index5 = array.indexOfFirst { it == "张三" }
    println(index5)
}

private fun m07() {
    val arr = arrayOf("a", 1, true, ArrayList<String>())
    arr.forEach { println(it) }
    arr[0] = 0
    arr.set(2, 2)
    arr.set(3, 3)
    arr.forEach { println(it) }
}

private fun m06() {
    val arr = arrayOf("apple", "banana", "orange")
    for (s in arr) {
        println(s)
    }
    arr.forEach {
        println(it)
    }
}

private fun m05() {
    val age = 7
    val result = todo(age)
    println(result)
}

fun todo(age: Int): String {
    return when (age) {
        7 -> {
            println("找到了分支")
            "开始上小学"
            "10"
        }
        12 -> "开始上中学"

        15 -> {
            "开始上高中"
        }
        18 -> {
            "开始上大学"
        }
        else -> {
            "开始上社会大学"
        }
    }
}

fun todo4(age: Int): String {
    when {
        age in 1..6 -> return "还没读书"
        age == 7 -> return "开始上小学"
        age in 8..11 -> return "在上小学"
        age == 12 -> return "开始上中学"
        age in 13..14 -> return "正在上中学"
        age == 15 -> return "开始上高中"
        age in 16..17 -> return "正在上高中"
        age == 18 -> return "开始上大学"
        age in 19..22 -> return "正在上大学"
        else -> return "开始上社会大学"
    }
}

fun todo3(age: Int): String {
    when (age) {
        in 1..6 -> return "还没读书"  //age in 区间中
        7 -> return "开始上小学"
        in 8..11 -> return "在上小学"
        12 -> return "开始上中学"
        13, 14 -> return "正在上中学"
        15 -> return "开始上高中"
        16, 17 -> return "正在上高中"
        18 -> return "开始上大学"
        in 19..22 -> return "正在上大学"
        else -> return "开始上社会大学"
    }
}

fun todo1(age: Int): String {
    when (age) {
        7 -> {
            return "开始上小学"
        }
        12 -> {
            return "开始上中学"
        }
        15 -> {
            return "开始上高中"
        }
        18 -> {
            return "开始上大学"
        }
        else -> {
            return "开始上社会大学"
        }
    }
}

//上面代码可以简化成如下代码
fun todo2(age: Int): String {
    when (age) {
        7 -> return "开始上小学"
        12 -> return "开始上中学"
        15 -> return "开始上高中"
        18 -> return "开始上大学"
        else -> return "开始上社会大学"
    }
}

private fun m03() {
    //反向区间
    val range = 10 downTo 1
    range.forEach {
        println(it)
    }
    //区间反转
    var reversed = range.reversed()
    reversed.forEach {
        println(it)
    }
    //设置步长
    for (i in reversed step 2) {
        println(i)
    }
}

private fun m02() {
    var range = 1..10
    for (i in range) {
        println(i)
    }
    for ((index, num) in range.withIndex()) {
        println("$index---$num")
    }
    range.forEach {
        println(it)
    }
    range.forEachIndexed { index, i -> println("$index---$i") }
}

private fun m01() {
    //定义1到10
    var range1 = 1..10
    var range2 = 1 until 10
    var range3 = IntRange(1, 10)
    var range4 = 1.rangeTo(10)

    /*---------------------------- 长整形区间 ----------------------------*/
    val range5 = 1L..10L
    val range6 = LongRange(1L, 100L)
    val range7 = 1L.rangeTo(10L)
    /*---------------------------- 字符区间 ----------------------------*/
    val range8 = 'a'..'z'
    val range9 = CharRange('a', 'z')
    val range10 = 'a'.rangeTo('z')
}